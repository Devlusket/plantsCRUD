# Definir o caso de uso

Ex:POST /plants deve aceitar X e retornar Y.

2️#Criar os DTOs primeiro

Por quê?

Porque DTO define o contrato da API.

Você decide:

Quais campos entram?

Quais saem?

Quais são obrigatórios?

O que não deve ser exposto?

Isso evita que a Entity dite sua API.

Esse é um erro comum de júnior:

Criar entidade e simplesmente expor ela no controller.

3️⃣ Criar a Entity

Agora você modela a persistência com base na regra de negócio, não no HTTP.

4️⃣ Criar Repository

Normalmente é quase automático:

interface PlantRepository extends JpaRepository<Plant, Integer>
5️⃣ Criar o Service

Aqui mora a regra.

Validação

Exceções

Transação

Orquestração

Mapping

6️⃣ Criar o Controller por último

Controller deve ser fino.

Ele só conecta HTTP → Service.

🎯 Então a ordem mais estratégica seria:
Use case
→ DTO (contrato)
→ Entity (persistência)
→ Repository
→ Service (regra)
→ Controller (exposição HTTP)