# Test Results

Command:

```bash
./gradlew.bat test
```

Latest observed result:

```text
BUILD SUCCESSFUL
```

Latest JaCoCo instruction coverage:

```text
Total: 91.45%
controller: 100%
exception: 100%
payment: 100%
service: 96.55%
dto: 89.93%
entity: 83.44%
util: 79.63%
application package: 62.50%
```

Generated reports:

- `build/reports/tests/test/index.html`
- `build/reports/jacoco/test/html/index.html`
- `build/reports/jacoco/test/jacocoTestReport.xml`

Coverage areas:

- Service layer behavior with mocked dependencies.
- Repository interaction verification.
- Dependency inversion through mocked interfaces.
- Payment polymorphism across multiple implementations.
- Immutable object behavior.
- Edge cases: null request, empty item list, invalid quantity, missing payment method, unsupported payment method, missing records.
- Controller delegation and HTTP status mapping.
- Exception-to-response mapping.
- Spring Boot launcher delegation without starting the real application context.
