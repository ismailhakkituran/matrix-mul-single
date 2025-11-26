matrix-mul-single
==================

Bu proje, **tek thread** kullanarak matris çarpımı yapan ve belirli bir süre içinde kaç adet çarpım gerçekleştirebildiğini ölçen basit bir **Java / Maven** konsol uygulamasıdır.

Amaç, matris çarpma işlemini:
- Temiz bir sınıf hiyerarşisi (POJO + handler) ile göstermek,
- Zaman bazlı (örneğin 1 saniye) bir benchmark ile performansı ölçmektir.

---

## Teknolojiler

- Java 17
- Maven
- `exec-maven-plugin` (main sınıfını çalıştırmak için)

veya 

```sh
cd matrix-mul-single
mvn -q -DskipTests package
mvn -q exec:java -Dexec.args="400 1"
```
---

## Sınıf Hiyerarşisi

Namespace (package): `com.example.single`

```text
com.example.single
 ├─ Matrix
 ├─ SingleThreadMatrixMultiplicationHandler
 └─ SingleThreadBenchmarkApp  (main sınıfı)

