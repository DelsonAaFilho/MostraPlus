# Repository Guidelines — Mostra+

## Escopo e fontes

Mostra+ é uma vitrine de projetos acadêmicos com submissão por alunos e avaliação docente. Leia `README.md`, os
documentos de requisitos/arquitetura em `docs/` e `docs/PLANEJAMENTO.md` antes de alterar regras de negócio. Os
documentos originais são fontes; não os sobrescreva durante a implementação.

O documento de requisitos é um rascunho. Divergências e decisões pendentes estão em DEC-01, DEC-02 e DEC-03. Não
transforme uma dúvida em requisito implementado silenciosamente. Instruções explícitas do responsável prevalecem;
registre decisões que alterem o escopo e atualize o planejamento.

## Estrutura e estado atual

Aplicação de módulo único, Java 21, Spring Boot e Maven. A base atual contém a inicialização e um teste de contexto, sem
funcionalidades de negócio, migrations ou frontend. Não documente funcionalidade planejada como já implementada.

- `src/main/java/com/example/a3work/`: raiz do código; `A3WorkApplication` é a entrada. Mantenha os novos pacotes sob
  essa raiz para component scanning.
- `src/main/resources/application.properties`: configuração; atualmente contém apenas o nome da aplicação.
- `src/main/resources/db/migration/`: destino das futuras migrations Flyway.
- `src/test/java/com/example/a3work/`: testes espelhando os pacotes de produção.
- `docs/`: requisitos, arquitetura e backlog rastreável.
- `pom.xml`, `.mvn/`, `mvnw*`: dependências, plugins e wrapper.
- `target/`: saída gerada, excluída do Git.

## Stack e arquitetura

Use Java 21, Spring Boot, Spring Web, Spring Data JPA, PostgreSQL Driver, Spring Security, Validation, Flyway, Actuator,
Spring Boot Test, Spring Security Test, springdoc e Brevo. Preserve as escolhas existentes; valide compatibilidade antes
de alterar versões. O POM utiliza starters modulares de Spring Boot, inclusive para testes.

Organize componentes por responsabilidade e domínio sob a raiz existente. Controllers lidam com HTTP e DTOs; serviços
aplicam regras, transações e autorização de negócio; repositories cuidam da persistência. Não exponha entidades JPA
diretamente nem aceite autoria/permissões fornecidas pelo cliente como autoridade.

Metadados e relacionamentos ficam no PostgreSQL. Imagens ficam em storage separado; o provedor está pendente de decisão.
Isole Brevo e storage em adaptadores testáveis. Tecnologia de interface, sessão e eventos de e-mail também dependem das
decisões do primeiro marco. Não acrescente recuperação de senha, verificação de e-mail ou perfil administrador como se
fossem requisitos confirmados.

## Invariantes do domínio

- Visitante acessa somente projetos aprovados e não retirados; aluno/professor mantêm acesso à vitrine.
- Apenas alunos submetem projetos. A menção a “Novo projeto” no perfil docente é uma divergência a resolver, não
  autorização para ampliar permissões.
- Cadastro de projeto válido inicia como Pendente; somente o professor atribuído pode avaliar.
- Reprovação exige comentário não vazio; aprovação publica imediatamente.
- Autor pode reenviar reprovado ao mesmo professor. Edição de aprovado pelo autor retira da vitrine e retorna a
  Pendente.
- Apenas o autor pode solicitar retirada de seu projeto aprovado; efeito público imediato, sem aprovação adicional.
  Política de retenção/exclusão permanece pendente de decisão.
- Preserve histórico de avaliações e reenvios, com professor, decisão, comentário e data/hora conforme o evento.
- Título até 100 caracteres, descrição até 500 e ao menos um participante. Categoria, site, e-mail e professor são
  obrigatórios; LinkedIn e GitHub são opcionais.
- Use as nove categorias da seção 8.1 dos requisitos. Valide categoria e professor pelo identificador no servidor.
- Até três imagens e um logo opcionais; JPG, PNG ou WebP, até 2 MB por arquivo. Valide tipo real, tamanho e autorização.
- Site de aplicativo aponta para página de download, não diretamente para executável.
- Paginação pública é numérica. Interface e mensagens são pt-BR; informar publicação de nomes/e-mail e coletar ciência.

## Build, execução e testes

Execute na raiz com JDK 21; no Windows use `mvnw.cmd`.

- `./mvnw spring-boot:run`: iniciar localmente.
- `./mvnw test`: executar testes.
- `./mvnw -Dtest=A3WorkApplicationTests test`: teste de contexto atual.
- `./mvnw clean verify`: build completo, testes e processamento de documentação configurado.

JPA e Flyway exigem datasource válido na inicialização e no teste de contexto. Não contorne falhas desabilitando
segurança, migrations ou testes para declarar sucesso. Informe claramente falhas de ambiente e verificações não
executadas.

Use JUnit Jupiter e classes `*Tests`, com nomes de métodos descritivos. Prefira testes unitários para regras e reserve
`@SpringBootTest` para integração. Para persistência, configure PostgreSQL isolado; não use banco de produção. Simule
Brevo e storage nos testes. Adicione testes para comportamento alterado e execute `./mvnw test` antes de submeter. Não
há limiar de cobertura configurado.

Cubra limites, transições inválidas, concorrência relevante, reprovação sem comentário e tentativa de acesso entre
diferentes alunos/professores. Os CA01–CA13 são a base da homologação; testes acompanham as funcionalidades, não ficam
adiados para o último marco.

## Estilo

Use quatro espaços e chaves de abertura na mesma linha em Java/XML. Classes em `UpperCamelCase`, métodos/campos em
`lowerCamelCase`, pacotes em minúsculas. Imports explícitos. Nomeie componentes por responsabilidade, por exemplo
`ProjectController`, `ProjectService`, `ProjectRepository`. Não há formatter/lint configurado; siga o código existente e
evite reformatações alheias à tarefa.

## Segurança e configuração

Nunca versione credenciais. Use `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME` e `SPRING_DATASOURCE_PASSWORD`;
chaves Brevo e configurações de storage devem vir do ambiente quando implementadas. Não invente propriedades como se já
fossem suportadas pelo código.

Proteja senhas com hash e salt; nunca exponha senha/hash em DTOs, logs ou e-mails. Aplique autorização por perfil e
vínculo no servidor, incluindo acesso direto a IDs e mídias. Adote HTTPS no ambiente de entrega e proteções de
sessão/CSRF/CORS adequadas à arquitetura decidida. Evite expor endpoints sensíveis do Actuator. Valide entradas e
uploads, use consultas parametrizadas e escape saída na interface.

Migrations usam nomes `V1__create_users.sql`, `V2__...sql`. Não reescreva migrations já aplicadas em ambientes
compartilhados; adicione outra migration. Mudanças de schema devem declarar impacto, estratégia de implantação e
recuperação.

## Fluxo, commits e pull requests

Siga dependências e critérios de aceite das issues. Os IDs do plano local (por exemplo, TEC-01) diferem dos números
remotos; consulte `docs/planejamento-github.json` para os números e URLs publicados. Verifique itens existentes antes de
publicar backlog para evitar duplicação; confirme resultados remotos antes de marcar a publicação como concluída.

Use branches e commits focados, com assuntos imperativos e concisos, por exemplo `Add project validation`. PRs devem
explicar problema e comportamento resultante, vincular issues reais, informar comandos/resultados de verificação e
destacar configuração ou migrations. Inclua screenshots para mudanças visíveis de interface.

Uma entrega está pronta quando seus critérios de aceite foram atendidos, testes pertinentes passaram, revisão foi
concluída e documentação corresponde ao código. Não encerre marcos somente porque a implementação começou; verifique
seus critérios de saída e homologação.
