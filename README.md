


### url para obtener
>- http://localhost:8762/webjars/swagger-ui/index.html


###
>- http://localhost:8762/graphiql


### crear usuario
### graphql
mutation {
  createUser(
    nombre: "Juan Pérez",
    email: "juan.perez@example.com",
    password: "123456"
  ) {
    id
    nombre
    email
    password
  }
}


### Actualizar usuario:
### graphql
mutation {
  updateUser(id: 1, nombre: "Nuevo Nombre", email: "nuevo@email.com") {
    id
    nombre
    email
  }
}

### Eliminar usuario:
### graphql
mutation {
  deleteUser(id: 1)
}

### obtener un usuario
query {
  userById(id: 1) {
    id
    nombre
    email
    # password  # ⚠️ No es recomendable exponer el password en las respuestas
  }
}