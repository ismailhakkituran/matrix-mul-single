package com.example.single;

public class SingleThreadMatrixMultiplicationHandler {

    public Matrix multiply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows())
            throw new IllegalArgumentException("A.cols must equal B.rows");

        int m = a.getRows();
        int n = a.getCols();
        int p = b.getCols();

        Matrix result = new Matrix(m, p);
        double[][] aData = a.getData();
        double[][] bData = b.getData();
        double[][] cData = result.getData();

        for (int i = 0; i < m; i++)
            for (int k = 0; k < n; k++) {
                double a_ik = aData[i][k];
                for (int j = 0; j < p; j++)
                    cData[i][j] += a_ik * bData[k][j];
            }
        return result;
    }
}
