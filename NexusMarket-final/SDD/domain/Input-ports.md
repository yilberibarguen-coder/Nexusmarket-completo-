# Input Ports

## Individual Use Cases
Existen **42 interfaces `*UseCase`**, una por cada servicio de dominio.

## Role Input Ports
Para cumplir la separación por rol se añadieron ocho contratos:

- `PublicAccessPort`
- `NaturalCustomerPort`
- `BusinessCustomerPort`
- `BusinessOperatorPort`
- `BusinessSupervisorPort`
- `TellerEmployeePort`
- `CommercialEmployeePort`
- `InternalAnalystPort`

Cada Role Input Port extiende únicamente los casos de uso que puede invocar ese rol. Las implementaciones concretas están en `adapters/useCases/` y delegan en los servicios de dominio.
