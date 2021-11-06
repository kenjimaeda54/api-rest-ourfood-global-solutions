### API REST, UORFOOD

## MOTIVACAO
- Criar uma API para ser consumida no front end,com persistência de dados no Banco da Oracle SQL
- API com 3 endpoints  Users,Products,Company
- Os 3 endpoints precisam  possuir recursos dos verbos comuns em uma aplicação rest. GET,POST,DELETE e PUT

## FETATURES
- Usamos projeto de software DAO
- Interface e implementada  por uma classe e por polimorfismo a camada Service fica responsável por comunicar com os controller
- Classe que implementa a interface DAO, responsável por toda logica do banco, SELECT,UPDATE,DELTE,INSERT.
- Controller faz as requestes com o servidor e retorna resposta para camada service
- Controller recebe as anotations, GET, PUT,DELTE,EDIT,POST

## PRODUCTS E COMPANY
- Esses duas entidades no banco possuem relação direta a entidade User
- Não e possível possuir empresa ou produtos sem usuários.
- Para fazer essa relação estamos usando o identificador único do usuário(user_id)







