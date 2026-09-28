# NexusMarket

Proyecto académico de **Construcción de Software 2** basado en DDD y Arquitectura Hexagonal.

## Qué contiene

- 42 servicios de dominio del catálogo original.
- 42 Input Ports individuales (`*UseCase`).
- 8 Role Input Ports y sus Use Case Adapters.
- 18 Output Ports.
- Entidades de dominio con comportamiento y reglas de negocio.
- Enums y Value Objects para roles, estados y tipos acotados.
- Adaptadores In-Memory para ejecución local.
- Boundary de persistencia JPA con DTOs, mappers y repositorio desacoplado.
- Boundary de auditoría MongoDB con documentos, mapper y repositorio desacoplado.
- Adaptadores REST/HTTP demostrativos.
- Autenticación con JWT HS256 sin librerías externas.
- Documentación SDD actualizada para coincidir con el código.
- Smoke test del flujo comprador → carrito → pedido → pago → confirmación.

## Estructura

```text
src/main/java/application/
├── domain/
│   ├── enums/
│   ├── valueobjects/
│   ├── model/
│   ├── ports/in/
│   ├── ports/out/
│   └── services/
├── adapters/
│   ├── useCases/
│   ├── rest/
│   ├── persistence/
│   │   ├── inmemory/
│   │   ├── jpa/
│   │   └── mongodb/
│   ├── security/
│   └── authorization/
└── NexusMarketApplication.java
```

## Verificación rápida sin instalar dependencias externas

Requiere Java 17 o superior.

### Compilar

```powershell
javac -d out $(Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object { $_.FullName })
```

En Windows PowerShell, si el comando anterior genera problemas de expansión, usar:

```powershell
Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object { $_.FullName } | Set-Content sources.txt
javac -d out @sources.txt
```

### Ejecutar smoke test

```powershell
Get-ChildItem -Recurse src/main/java,src/test/java -Filter *.java | ForEach-Object { $_.FullName } | Set-Content sources.txt
javac -d out @sources.txt
java -cp out application.NexusMarketSmokeTest
```

Resultado esperado:

```text
NexusMarket smoke test: PASS
```

## Maven

También se conserva `pom.xml` para integración con Maven/IDE. El código central no depende de Spring, JPA ni MongoDB, lo que permite verificar la arquitectura y los servicios sin infraestructura externa. Los boundaries `jpa/` y `mongodb/` están preparados para conectar Spring Data en la capa de infraestructura sin contaminar el dominio.

## Regla arquitectónica

El dominio no importa adapters. Los servicios dependen de Output Ports y los Use Case Adapters dependen de los servicios de dominio.

## Documentación

La carpeta `SDD/` contiene el modelo, value objects, servicios, Input Ports, Output Ports y arquitectura de implementación.
