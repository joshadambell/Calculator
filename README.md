# Calculator

## Operations
  - add
  - sub
  - mul
  - div
  
## Operands 
  - +
  - -
  - /
  - *

## /calculate

### POST /{ operation }

##### Request body
```
{
  "first": { number }
  "second": { number }
}
```

##### Response body

````
{
  "result": { result }
}
````

### POST /calculate

##### Request body
```
[{
  "first": { number },
  "second": { number }
  "operand": { operand or operation }
  "name": { whatever }
},
{
  "first": { number },
  "second": { number }
  "operand": { operand or operation }
  "name": { whatever }
}...]
```

##### Response body

````
[{
  "{ name }": { result },
  "{ name }": { result }
}]
````

### POST /custom

##### Request body
```
{
  "operand": { operand }
  "operation": { operation }
}
```

##### Response header
201 Created
````
  Location: { url }
````
