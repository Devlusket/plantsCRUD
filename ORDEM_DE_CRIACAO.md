# Então a ordem mais estratégica seria:
# → Use case
# → DTO (contrato)
# → Entity (persistência)
# → Repository
# → Service (regra)
# → Controller (exposição HTTP)


# Definir o caso de uso

Ex: POST /plants deve aceitar X e retornar Y.

# Criar os DTOs primeiro

Porque DTO define o contrato da API.
Você decide:
Quais campos entram?
Quais saem?
Quais são obrigatórios?
O que não deve ser exposto?
Isso evita que a Entity dite sua API.

# Criar a Entity

Agora você modela a persistência com base na regra de negócio, não no HTTP.

# Criar Repository

Normalmente é quase automático:

# Criar o Service

Aqui mora a regra.
Validação
Exceções
Transação
Orquestração
Mapping

# Criar o Controller por último

Ele só conecta HTTP → Service.