# Arquitectura de Implementación — NexusMarket

## Arquitectura hexagonal
```text
REST / HTTP / CLI
      |
      v
Role Input Ports (domain/ports/in/*Port)
      |
      v
Use Case Adapters (adapters/useCases)
      |
      v
Domain Services (42 servicios)
      |
      v
Output Ports (domain/ports/out)
      |
      +--> InMemory adapters (ejecución y pruebas)
      +--> JPA persistence boundary (entities/mappers/repository contract)
      +--> MongoDB audit boundary (documents/mappers/repository contract)
```

## Capas
- `domain/model`: entidades y comportamiento de negocio.
- `domain/enums` y `domain/valueobjects`: conceptos acotados y validaciones.
- `domain/ports/in`: 42 contratos de casos de uso + 8 agrupaciones por rol.
- `domain/services`: exactamente 42 servicios del catálogo original; `ServiceSupport` es una utilidad compartida y no cuenta como servicio de negocio.
- `domain/ports/out`: contratos de persistencia, seguridad, autorización y notificación.
- `adapters/useCases`: implementaciones concretas de los 8 Role Input Ports que delegan en servicios de dominio.
- `adapters/rest`: DTOs, controladores y servidor HTTP demostrativo.
- `adapters/persistence/inmemory`: adaptadores ejecutables sin infraestructura externa.
- `adapters/persistence/jpa`: DTOs de persistencia, mapper y contrato de repositorio desacoplado del dominio.
- `adapters/persistence/mongodb`: documentos, mapper y contrato de repositorio para auditoría.
- `adapters/security`: hashing y JWT HS256 sin dependencia externa.

## Principios aplicados
1. Dependencia hacia adentro: el dominio no importa adapters.
2. Los servicios reciben Output Ports, no repositorios concretos.
3. Los controladores no contienen reglas de negocio.
4. Las entidades de persistencia no son entidades de dominio.
5. Los roles y tipos acotados se expresan mediante enums.
6. La infraestructura puede sustituirse sin reescribir los servicios de dominio.
