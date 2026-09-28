# Modelo de Dominio — NexusMarket

## Propósito
NexusMarket es un marketplace donde compradores consultan productos, administran carritos, generan pedidos, realizan pagos, reciben envíos y gestionan devoluciones/reembolsos. Los vendedores publican productos y administran inventario; los empleados operan procesos internos.

## Jerarquía
```text
Person (abstract)
├── Customer
│   └── Buyer
├── Seller
└── Employee (abstract)
    ├── Administrator
    ├── SupportAgent
    ├── LogisticOperator
    └── Supervisor

Product
Category
Warehouse
Inventory
InventoryMovement
Cart / CartItem
Order / OrderItem
Invoice
Payment
Shipment
Address
Review
ReturnRequest / Refund
Wishlist
Coupon / Promotion
Operation / AuditLog
User
```

## Entidades principales

| Entidad | Responsabilidad |
|---|---|
| `User` | Cuenta autenticable, rol y estado de acceso. |
| `Buyer` / `Customer` | Perfil comprador, direcciones, carrito y pedidos. |
| `Seller` | Actor vendedor propietario de productos. |
| `Employee` | Base para actores internos con rol operativo. |
| `Administrator` | Administración global. |
| `SupportAgent` | Soporte y devoluciones. |
| `LogisticOperator` | Operación de envíos. |
| `Supervisor` | Supervisión de operaciones. |
| `Product` | Producto comercial con precio, tipo, estado, categoría y vendedor. |
| `Category` | Clasificación de productos. |
| `Warehouse` | Bodega física con ubicación y estado. |
| `Inventory` | Existencias disponibles/reservadas por producto y, cuando aplica, bodega. |
| `InventoryMovement` | Registro de movimientos de inventario tipificados. |
| `Cart` / `CartItem` | Selección temporal de productos. |
| `Order` / `OrderItem` | Pedido y sus líneas. |
| `Invoice` | Documento comercial asociado al pedido. |
| `Payment` | Registro y estado del pago. |
| `Shipment` | Proceso de entrega. |
| `ReturnRequest` / `Refund` | Devolución y reembolso. |
| `Wishlist` | Productos guardados por el comprador. |
| `Review` | Valoración de un producto. |
| `Coupon` / `Promotion` | Incentivos comerciales. |
| `Operation` / `AuditLog` | Trazabilidad de acciones significativas. |

## Reglas de negocio
1. Los identificadores obligatorios no pueden estar vacíos.
2. El precio de un producto debe ser positivo.
3. Un vendedor solo modifica sus productos, salvo roles administrativos.
4. El inventario nunca puede quedar negativo.
5. Las reservas reducen disponible y aumentan reservado; las liberaciones hacen el proceso inverso.
6. Un carrito pertenece a un único cliente.
7. Un pedido no puede crearse desde un carrito vacío.
8. El pedido reserva el inventario antes de quedar en `PENDING_PAYMENT`.
9. Un pago aprobado debe cubrir el total para confirmar el pedido.
10. Un pedido entregado no se cancela; puede iniciar devolución según la política.
11. Las devoluciones aprobadas pueden generar reembolso.
12. Las operaciones sensibles requieren autorización por rol.
13. Los servicios de dominio contienen las reglas; los adaptadores solo traducen o conectan infraestructura.
14. El dominio no depende de HTTP, JSON, bases de datos ni frameworks.
