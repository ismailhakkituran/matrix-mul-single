package com.example.single;

import java.util.Random;

public class SingleThreadBenchmarkApp {
    public static void main(String[] args) {
        int size = 500;
        long durationSeconds = 1;

        if (args.length >= 1) size = Integer.parseInt(args[0]);
        if (args.length >= 2) durationSeconds = Long.parseLong(args[1]);

        System.out.println("=== Single-thread Benchmark ===");
        System.out.println("Matrix: " + size + "x" + size);

        Random random = new Random(42);
        Matrix a = Matrix.randomMatrix(size, size, -1, 1, random);
        Matrix b = Matrix.randomMatrix(size, size, -1, 1, random);

        SingleThreadMatrixMultiplicationHandler handler = new SingleThreadMatrixMultiplicationHandler();

        for (int i = 0; i < 5; i++) handler.multiply(a, b);

        long durationNanos = durationSeconds * 1_000_000_000L;
        long end = System.nanoTime() + durationNanos;

        long count = 0;
        while (System.nanoTime() < end) {
            handler.multiply(a, b);
            count++;
        }

        System.out.println("Mult/s: " + count / durationSeconds);
    }
}
