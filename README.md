# Projeto 01
## Jogo - Pedra, Papel ou Tesoura

***

### Definições

- 2 Activies
    - MainActivity: Aparece apenas na inicialização do APP, fará o papel de Splash Screen
    - GameActivity: Responsável por toda a execução do jogo
    
***

#### Steps

- 01
    - Configuração do layout da splash screen
    
- 02
    - Criação da GameActivity
    - Navegação para GameActivity
    
- 03
    - Configuração de parte do layout da Game Activity
    - Configuração de ClickListeners
    
- 04
    - Configuração do layout referente ao placar do jogo
    
- 05
    - Pequeno refactor no layout do score do jogo
    - Utilizando área do jogo para printar a escolha do usuário
    
- 06
    - Atualizar texto na área do jogo utilizando data binding
    
- 07: Refactor Challenge
    - Implementar Navigation Component
    - Adicionar Screen entre Splash e Game para input do Nome do Jogador
    - Implementar Safe Args
    
- 08: Ranking Challenge
    - Adicionar novo fragment para Top 10
    - Criar navegação para fragment Top 10
    - Salvar nome do jogador utilizando SharedPreferences
    - Salvar Top 10 utilizando SharedPreferences
    - Renderizar Top 10 utilizando RecycleView
    
```
val MOCK = arrayListOf<RankingItem>(
    RankingItem("João", 1212, 1),
    RankingItem("Maria", 1111, 2),
    RankingItem("João", 735, 3),
    RankingItem("Chuck", 722, 4),
    RankingItem("Peter Pan", 716, 5),
    RankingItem("Peter Pan", 544, 6),
    RankingItem("Sofia", 543, 7),
    RankingItem("Alberto", 541, 8),
    RankingItem("Bart", 212, 9),
    RankingItem("Homer", 71, 10)
)
```  
    