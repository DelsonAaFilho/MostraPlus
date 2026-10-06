# Planejamento de desenvolvimento — Mostra+

Status: publicado e verificado no GitHub em `DelsonAaFilho/A3_Web`: 6 milestones e 26 issues, com dependências e critérios de aceite.

## Base e escopo

Fontes: `Analise_de_Requisitos_Mostra+.docx` (v1.0, rascunho de 18/09/2026), `Documento de Arquitetura e Fluxo 2 (1).pdf`, stack solicitada pelo responsável e estado atual do código. RF, RN, RNF e CA referem-se ao DOCX. DEC-03 e MAIL-01 derivam da inclusão explícita de Brevo pelo responsável. IDs como TEC-01 são identificadores locais, não números de issues do GitHub.

Os marcos indicam ordem de entrega, sem datas, responsáveis ou estimativas inventados. Questões de produto ficam no primeiro marco. Testes acompanham cada funcionalidade; o último marco consolida homologação e operação. A interface faz parte dos requisitos, mas sua tecnologia permanece em decisão.

Prioridade é da entrega agrupada: requisitos Importantes ou Desejáveis são identificados no corpo quando coexistem com Essenciais. A integração Brevo é exigência adicional da stack; eventos aguardam decisão.

### Atualização local de modelagem — 05/10/2026

Por orientação do responsável nesta sessão, o modelo adota **de 1 a 10 participantes por projeto**: mantém o mínimo original e acrescenta o máximo solicitado. A especificação está em [DATABASE.md](DATABASE.md), incluindo tabelas, colunas, chaves, versionamento dos envios e serialização. Trata-se de proposta de modelo, sem entidades ou migrations de negócio implementadas nesta tarefa.

O limite afeta TEC-02, PROJ-02 e UI-03. Validar a coleção no servidor e o máximo no banco; a interface deve impedir adicionar o 11º participante. Esta atualização é local: as issues do GitHub e o arquivo de registro da publicação ainda não foram sincronizados com esta nova regra.

## Marcos e critérios de saída

### M1 — Requisitos e decisões de arquitetura

[Ver milestone no GitHub](https://github.com/DelsonAaFilho/A3_Web/milestone/1)

Resolver ambiguidades de produto, definir contratos, sessão, interface, storage e eventos de e-mail. Saída: decisões registradas e backlog validado; sem datas artificiais.

### M2 — Fundação técnica e persistência

[Ver milestone no GitHub](https://github.com/DelsonAaFilho/A3_Web/milestone/2)

Preparar Java 21, dependências, PostgreSQL/Flyway, testes isolados e integração contínua. Saída: build reproduzível e modelo persistente validado.

### M3 — Identidade, acesso e submissão

[Ver milestone no GitHub](https://github.com/DelsonAaFilho/A3_Web/milestone/3)

Entregar cadastro/login/logout, autorização, catálogos, submissão e mídias. Saída: aluno envia projeto pendente acessível apenas aos envolvidos.

### M4 — Curadoria e ciclo de vida

[Ver milestone no GitHub](https://github.com/DelsonAaFilho/A3_Web/milestone/4)

Entregar avaliação, histórico, acompanhamento, reenvio, edição e retirada. Saída: transições e autoria comprovadas por testes.

### M5 — Vitrine, interface e e-mails

[Ver milestone no GitHub](https://github.com/DelsonAaFilho/A3_Web/milestone/5)

Entregar navegação pública e áreas autenticadas integradas, Brevo e requisitos de experiência. Saída: jornada completa disponível para homologação.

### M6 — Homologação e entrega

[Ver milestone no GitHub](https://github.com/DelsonAaFilho/A3_Web/milestone/6)

Validar critérios de aceite, segurança, desempenho, operação e documentação. Saída: versão homologada com implantação e recuperação documentadas.

## Fluxo de trabalho

1. Refinar a issue e resolver dependências e decisões antes de implementar.
2. Criar branch focada; desenvolver comportamento e testes juntos.
3. Abrir PR vinculada à issue com mudança, evidências e impacto em configuração/migrations.
4. Revisar e executar CI; integrar somente com critérios de aceite atendidos.
5. Homologar e encerrar a issue; encerrar o milestone após verificar seu critério de saída.

## Issues publicadas

### DEC-01 — Decidir ambiguidades de perfis, edição e retirada de projetos

[Issue #1](https://github.com/DelsonAaFilho/A3_Web/issues/1)

- Marco: M1
- Tipo: Decisão
- Prioridade: Essencial
- Rastreabilidade: RN03, RN09, RN21–22; RF31, RF33–36; seção 9; PDF §§2–3
- Dependências: nenhuma

Validar com equipe/docente as divergências sem ampliar permissões por interpretação. Perguntas: o atalho “Novo projeto” no perfil do professor é erro documental? A retirada será lógica ou física, e por quanto tempo histórico e mídias serão preservados? É permitido editar projetos pendentes? A escolha direta de professor no cadastro permanece como descrita, ou haverá validação institucional?

Critérios de aceite:

- [ ] Registrar respostas e responsável pela decisão; enquanto não houver alteração aprovada, professor apenas avalia e não submete projetos.
- [ ] Preservar edição pelo autor, retorno a Pendente, retirada pública imediata e reenvio ao mesmo professor.
- [ ] Atualizar matriz de permissões e transições; distinguir retirada do estande de política de eliminação dos dados.

### DEC-02 — Definir interface, contratos HTTP, sessão e armazenamento de imagens

[Issue #2](https://github.com/DelsonAaFilho/A3_Web/issues/2)

- Marco: M1
- Tipo: Decisão
- Prioridade: Essencial
- Rastreabilidade: RF01–40; RNF05–09; PDF §§1–2
- Dependências: nenhuma

Definir como a interface será entregue com o backend Java: renderização no servidor ou frontend separado (tecnologia ainda não escolhida). Decidir sessão/cookies ou tokens, expiração/logout, CSRF/CORS, contratos de erro, paginação, busca, ordenação e storage separado do PostgreSQL. Não selecionar fornecedor pago automaticamente.

Critérios de aceite:

- [ ] Registrar diagrama e decisões com justificativa e responsabilidades por camada.
- [ ] Definir payloads, rotas públicas/restritas, códigos de erro e estratégia de testes; não persistir binários de imagens no banco.
- [ ] Definir campos pesquisáveis, tamanho de página, ordenação estável e comportamento de vazios/URLs inválidas.
- [ ] Definir proteção e remoção de mídias de projetos não públicos, incluindo URLs diretas e cache.

### DEC-03 — Definir eventos, destinatários e política de envio pelo Brevo

[Issue #3](https://github.com/DelsonAaFilho/A3_Web/issues/3)

- Marco: M1
- Tipo: Decisão
- Prioridade: Essencial
- Rastreabilidade: Stack solicitada pelo usuário; RF26, RF30 e RF40 como contexto
- Dependências: nenhuma

Brevo é parte da stack solicitada, mas os documentos não exigem eventos de e-mail específicos. Confirmar quais eventos geram mensagem (submissão, aprovação, reprovação ou reenvio), destinatários, conteúdo, remetente/domínio, templates, tratamento de falhas e duplicidades. Verificação de conta e recuperação de senha não são requisitos confirmados.

Critérios de aceite:

- [ ] Registrar eventos aprovados, destinatários e conteúdo mínimo em pt-BR.
- [ ] Definir integração por API HTTP ou SDK compatível, configuração por ambiente e simulação em testes.
- [ ] Definir limites de tentativas, retentativa e comportamento em indisponibilidade sem perder a transação de negócio.
- [ ] Senhas, chaves e dados desnecessários não aparecem nas mensagens ou logs.

### TEC-01 — Validar dependências e configuração de ambientes Java 21

[Issue #4](https://github.com/DelsonAaFilho/A3_Web/issues/4)

- Marco: M2
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: Stack solicitada; pom.xml
- Dependências: DEC-02, DEC-03

Revisar compatibilidade das versões efetivas de Spring Boot, springdoc e bibliotecas; manter Maven Wrapper e Java 21. O POM atual declara Boot 4.1.1, springdoc 3.1.0, starters modulares de testes, Actuator, JPA, Flyway e REST client; integração Brevo ainda não implementada.

Critérios de aceite:

- [ ] Build resolve dependências sem conflitos e compila em Java 21.
- [ ] Cobrir Spring Web, Data JPA, driver PostgreSQL, Security, Validation, Flyway, Actuator, testes Spring/Security, springdoc e integração Brevo.
- [ ] Separar configuração local/teste/produção; documentar variáveis sem incluir credenciais.
- [ ] README diferencia recursos disponíveis de planejados.

### TEC-02 — Modelar domínio e criar migrations PostgreSQL com Flyway

[Issue #5](https://github.com/DelsonAaFilho/A3_Web/issues/5)

- Marco: M2
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN03, RN05–18, RN21–22; RNF15; seção 8; PDF §1
- Dependências: DEC-01, DEC-02, TEC-01

Modelar usuários, projetos, participantes, categorias, referências de mídias, decisões de avaliação e eventos de reenvio. Definir autoria, professor responsável, timestamps e retirada conforme decisão de produto.

Critérios de aceite:

- [ ] Migrations criam banco vazio; reaplicação do Flyway não altera migrations executadas.
- [ ] Garantir e-mail único, relacionamentos e integridade referencial.
- [ ] Modelar de 1 a 10 participantes por projeto/versão, garantindo o máximo no banco e o mínimo no serviço.
- [ ] Carregar as nove categorias documentadas sem duplicatas.
- [ ] Persistir histórico sem sobrescrever reprovações; separar URLs/chaves de storage dos binários.
- [ ] Usar isolamento transacional e estratégia de concorrência para transições de estado.

### TEC-03 — Preparar testes isolados e CI com PostgreSQL

[Issue #6](https://github.com/DelsonAaFilho/A3_Web/issues/6)

- Marco: M2
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RNF05–08, RNF15; CA01–13; convenções do repositório
- Dependências: TEC-01, TEC-02

Configurar banco de teste isolado e pipeline Maven/Java 21, sem credenciais de produção nem envio real pelo Brevo. Usar PostgreSQL para comportamento dependente do banco; decidir serviço efêmero ou Testcontainers conforme ambiente.

Critérios de aceite:

- [ ] ./mvnw test e ./mvnw clean verify passam em ambiente limpo com banco isolado.
- [ ] CI executa em pull requests e registra falhas de testes.
- [ ] Testes aplicam migrations reais; clients externos são substituídos por doubles.
- [ ] Context test deixa de depender de configuração manual ou de dados locais.

### AUTH-01 — Implementar cadastro e autenticação por e-mail e senha

[Issue #7](https://github.com/DelsonAaFilho/A3_Web/issues/7)

- Marco: M3
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN02–04, RN19; RF10–13; RNF05; CA02
- Dependências: DEC-01, DEC-02, TEC-02, TEC-03

Criar conta com nome, e-mail único, senha e perfil aluno/professor conforme decisão validada. Implementar login e proteção de credenciais no servidor.

Critérios de aceite:

- [ ] Validar campos, duplicidade de e-mail e perfis aceitos; senha armazenada com hash e salt.
- [ ] Login válido estabelece identidade e perfil; inválido não cria sessão e retorna erro claro.
- [ ] Respostas nunca expõem hash/senha; testes cobrem cadastro, duplicidade e credenciais inválidas.

### AUTH-02 — Aplicar autorização, sessão protegida e logout

[Issue #8](https://github.com/DelsonAaFilho/A3_Web/issues/8)

- Marco: M3
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN01–06; RF09, RF12–14; RNF05–08, RNF14; PDF §2
- Dependências: AUTH-01

Aplicar Spring Security nas rotas e serviços com checagem de autoria e professor atribuído, usando a estratégia de sessão definida. Visitantes mantêm acesso apenas ao conteúdo público.

Critérios de aceite:

- [ ] Visitante sem autenticação não acessa áreas privadas; interface encaminha ao login e API retorna resposta adequada ao contrato.
- [ ] Aluno não avalia, professor não cadastra e nenhuma troca de ID concede acesso a projeto alheio.
- [ ] Logout invalida a autenticação conforme estratégia escolhida.
- [ ] Testes Spring Security verificam autenticação, perfis, CSRF quando aplicável e acesso horizontal indevido.

### PROJ-01 — Disponibilizar categorias e professores elegíveis

[Issue #9](https://github.com/DelsonAaFilho/A3_Web/issues/9)

- Marco: M3
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN17–18; RF20, RF25; seção 8.1
- Dependências: AUTH-02, TEC-02

Fornecer dados para as seleções de categoria e professor; vínculo sempre validado no servidor.

Critérios de aceite:

- [ ] Categorias: Educação, Saúde, Negócios, Produtividade, Viagens, Cotidiano, Acessibilidade, Automação e IA.
- [ ] Listar somente professores elegíveis, expondo apenas dados necessários à seleção.
- [ ] Rejeitar categoria inexistente ou ID de aluno usado como professor.

### PROJ-02 — Implementar cadastro validado e submissão de projetos

[Issue #10](https://github.com/DelsonAaFilho/A3_Web/issues/10)

- Marco: M3
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN05, RN11–18; RF16–17, RF19, RF23–27; CA03, CA07
- Dependências: PROJ-01

Criar projeto pelo aluno autenticado, com participantes, professor, categoria, contatos e links. Aplicar DTOs, Bean Validation e regras de negócio na camada de serviço.

Critérios de aceite:

- [ ] Título obrigatório com até 100 caracteres, descrição até 500 e de 1 a 10 participantes.
- [ ] Exigir categoria, link de site, e-mail de contato e professor; LinkedIn/GitHub são opcionais e validados quando presentes.
- [ ] Para aplicativos, aceitar página de download e rejeitar link direto de executável conforme política validada.
- [ ] Autoria vem da autenticação; status inicial Pendente e confirmação de envio.
- [ ] Projeto pendente só é acessível ao autor e professor responsável; testes verificam limites e campos inválidos.

### MEDIA-01 — Implementar upload e acesso seguro a logo e imagens

[Issue #11](https://github.com/DelsonAaFilho/A3_Web/issues/11)

- Marco: M3
- Tipo: Implementação
- Prioridade: Importante
- Rastreabilidade: RN12; RF21–22; RNF08–09; CA08; PDF §1
- Dependências: DEC-02, AUTH-02, PROJ-02

Integrar storage isolado para mídias, persistindo apenas metadados e referências. Tratar upload, substituição, leitura e limpeza de arquivos sem dono.

Critérios de aceite:

- [ ] Aceitar logo opcional e no máximo três imagens opcionais, cada arquivo até 2 MB em JPG, PNG ou WebP.
- [ ] Validar conteúdo/tipo e tamanho no servidor; rejeitar quarta imagem e arquivos disfarçados.
- [ ] Restringir alteração ao autor e leitura de mídias privadas aos envolvidos; prevenir acesso público por URL direta.
- [ ] Falhas parciais não deixam referências inválidas; usar nomes de objeto gerados pelo servidor.

### FLOW-01 — Implementar aprovação, reprovação e histórico de avaliações

[Issue #12](https://github.com/DelsonAaFilho/A3_Web/issues/12)

- Marco: M4
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN06–08; RF36, RF38–40; RNF15; CA04–06
- Dependências: AUTH-02, PROJ-02

Implementar transições transacionais de Pendente para Aprovado ou Reprovado pelo professor responsável, registrando decisão e histórico.

Critérios de aceite:

- [ ] Aprovar publica imediatamente; reprovar exige comentário não vazio.
- [ ] Somente professor atribuído avalia projetos pendentes; acesso por outro professor é negado.
- [ ] Histórico registra projeto, professor, decisão, comentário e data/hora; comentário pode ser ausente na aprovação.
- [ ] Testes cobrem decisões concorrentes/repetidas e evitam transições inválidas.

### FLOW-02 — Implementar acompanhamento do aluno e do professor

[Issue #13](https://github.com/DelsonAaFilho/A3_Web/issues/13)

- Marco: M4
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RF27–30, RF35–37
- Dependências: FLOW-01

Entregar consultas privadas por perfil, status e vínculo, com detalhes e comentário de reprovação.

Critérios de aceite:

- [ ] Aluno vê somente seus projetos agrupados em pendentes, reprovados e publicados.
- [ ] Professor vê pendentes e aprovados atribuídos e detalhes necessários à avaliação.
- [ ] Aluno vê comentário da reprovação; histórico não vaza na API pública.
- [ ] Testes com dois alunos e dois professores verificam isolamento por identidade.

### FLOW-03 — Implementar edição e reenvio com nova avaliação

[Issue #14](https://github.com/DelsonAaFilho/A3_Web/issues/14)

- Marco: M4
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN09; RF31, RF33; RNF14–15; CA10–12
- Dependências: DEC-01, FLOW-01

Permitir ao autor corrigir projeto reprovado e editar aprovado. Preservar o professor responsável e o histórico.

Critérios de aceite:

- [ ] Reenvio de reprovado retorna a Pendente para o mesmo professor.
- [ ] Edição de aprovado retira imediatamente da vitrine e retorna a Pendente antes de nova publicação.
- [ ] Outro aluno não edita nem reenvia; validar novamente todos os campos e mídias.
- [ ] Histórico de decisões e reenvios é preservado; testes cobrem revisão e concorrência.

### FLOW-04 — Implementar retirada do estande pelo aluno autor

[Issue #15](https://github.com/DelsonAaFilho/A3_Web/issues/15)

- Marco: M4
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN21–22; RF34; RNF14; CA13
- Dependências: DEC-01, FLOW-01

Implementar solicitação de retirada de projeto aprovado com efeito imediato, conforme política de persistência decidida.

Critérios de aceite:

- [ ] Somente autor pode retirar seu projeto aprovado; não exigir aprovação adicional do professor.
- [ ] Projeto deixa de aparecer na listagem e detalhe públicos; tratar caches e acesso às mídias conforme política.
- [ ] Tentativa de outro usuário é negada; repetição e conflitos de estado têm comportamento documentado.
- [ ] Preservar ou eliminar registros e arquivos conforme decisão explícita de retenção.

### PUBLIC-01 — Criar consultas públicas com busca, filtros e paginação

[Issue #16](https://github.com/DelsonAaFilho/A3_Web/issues/16)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RN01, RN10, RN20; RF01, RF03–08; RNF01; CA01, CA09
- Dependências: FLOW-03, FLOW-04

Expor listagem paginada e detalhe somente leitura de projetos aprovados e não retirados.

Critérios de aceite:

- [ ] Busca e filtro por categoria combinam com paginação numérica e ordenação estável.
- [ ] Detalhe inclui título, participantes, descrição, categoria, professor, site, contato e mídias/links opcionais existentes.
- [ ] Pendente, reprovado e retirado não vazam por ID, busca, contagens ou mídia.
- [ ] Testar vazios, limites de página e remoção imediata após revisão/retirada.

### UI-01 — Construir vitrine pública e detalhe responsivos

[Issue #17](https://github.com/DelsonAaFilho/A3_Web/issues/17)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RF01–08, RF15; RNF01–04, RNF10, RNF12; CA01, CA09
- Dependências: DEC-02, PUBLIC-01, MEDIA-01

Implementar interface na tecnologia escolhida, integrada aos contratos do backend.

Critérios de aceite:

- [ ] Página principal tem banner com título/descrição, pesquisa, filtros e cards com logo (ou alternativa visual), título e categoria.
- [ ] Paginação numérica sem rolagem infinita; busca/filtros mantêm estado previsível.
- [ ] Detalhe somente leitura mostra todos os campos definidos; links opcionais ausentes não deixam controles vazios.
- [ ] Cabeçalho oferece entrada para alunos/professores; interface pt-BR, responsiva, teclado e textos alternativos.

### UI-02 — Construir cadastro, login, perfil e logout

[Issue #18](https://github.com/DelsonAaFilho/A3_Web/issues/18)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RF09–15; RNF02–05, RNF12
- Dependências: AUTH-02, DEC-02

Implementar jornadas de acesso e navegação por perfil, incluindo mensagens de erro.

Critérios de aceite:

- [ ] Criar conta com nome, e-mail, senha e escolha do perfil conforme decisão aprovada.
- [ ] Login inválido apresenta erro e área restrita não é aberta; logout encerra acesso.
- [ ] Usuário autenticado navega pela vitrine e retorna à própria área.
- [ ] Formulários possuem labels, foco visível e erros acessíveis em pt-BR.

### UI-03 — Construir submissão e área do aluno com ciência de publicação

[Issue #19](https://github.com/DelsonAaFilho/A3_Web/issues/19)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RF16–34; RNF02–04, RNF13; CA03, CA07–08, CA10–13
- Dependências: UI-02, FLOW-02, FLOW-03, FLOW-04, MEDIA-01

Integrar formulário, status, comentários, edição/reenvio e retirada. Informar a publicação de nomes e e-mail e coletar ciência do aluno, conforme documento de requisitos.

Critérios de aceite:

- [ ] Formulário cobre campos obrigatórios/opcionais, de 1 a 10 participantes, categorias, professor e limites de upload.
- [ ] Exibir validações e contador de descrição (RF18 Desejável), sem depender do frontend para impor o limite obrigatório.
- [ ] Perfil exibe projetos por status, atalho Novo projeto, comentários e ações permitidas.
- [ ] Registrar ciência antes da submissão; LinkedIn/GitHub continuam opcionais.
- [ ] Testar jornada de edição de aprovado e retirada da vitrine com atualização da interface.

### UI-04 — Construir área de avaliação do professor

[Issue #20](https://github.com/DelsonAaFilho/A3_Web/issues/20)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RF35–40; RNF02–04; CA04–06
- Dependências: UI-02, FLOW-02

Integrar listagem de projetos atribuídos, detalhes e ações de avaliação.

Critérios de aceite:

- [ ] Listar pendentes e aprovados atribuídos com acesso ao detalhe privado.
- [ ] Aprovar atualiza status e reprovar exige comentário, exibindo erros de servidor.
- [ ] Não oferecer cadastro de projeto ao professor sem mudança explícita da matriz de permissões.
- [ ] Validar teclado, foco e pt-BR; impedir envio duplicado acidental.

### MAIL-01 — Integrar Brevo para os eventos de e-mail aprovados

[Issue #21](https://github.com/DelsonAaFilho/A3_Web/issues/21)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: Stack solicitada; decisão DEC-03
- Dependências: DEC-03, TEC-01, FLOW-03

Criar adaptador de e-mail desacoplado do domínio com API HTTP ou SDK escolhido. Enviar somente eventos aprovados, usando templates em pt-BR.

Critérios de aceite:

- [ ] Configurar chave, remetente e templates por ambiente, sem segredos no Git ou logs.
- [ ] Falha ou timeout no Brevo não desfaz submissão/avaliação concluída.
- [ ] Aplicar política de retentativa e prevenção de duplicidade definida; registrar resultado sem dados sensíveis.
- [ ] Testes simulam sucesso, erro, indisponibilidade e repetição; homologação usa destinatários controlados.

### DOC-01 — Documentar contratos OpenAPI e exemplos de uso

[Issue #22](https://github.com/DelsonAaFilho/A3_Web/issues/22)

- Marco: M5
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: springdoc solicitado; RF01–40
- Dependências: PUBLIC-01, FLOW-04, MAIL-01

Documentar operações implementadas, autenticação, modelos, paginação, validações e estados usando springdoc.

Critérios de aceite:

- [ ] OpenAPI corresponde aos endpoints reais e inclui erros de autenticação/autorização e validação.
- [ ] Exemplos cobrem cadastro, submissão, avaliação, reenvio, retirada e consulta pública.
- [ ] Documentar acesso ao Swagger UI por ambiente e evitar exposição de dados sensíveis.

### QA-01 — Automatizar critérios de aceite e homologar jornadas

[Issue #23](https://github.com/DelsonAaFilho/A3_Web/issues/23)

- Marco: M6
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: CA01–13; RF01–40; RNF14–15
- Dependências: UI-01, UI-03, UI-04, MAIL-01, DOC-01

Consolidar testes unitários, integração PostgreSQL e jornadas de interface. Rastrear cada CA à evidência e registrar aceite da equipe/docente.

Critérios de aceite:

- [ ] Cobrir CA01 a CA13, incluindo comentário obrigatório, limites, autorização cruzada, reenvio e retirada.
- [ ] Executar matriz visitante/aluno/professor e cenários de falha do storage/Brevo.
- [ ] Registrar evidências de homologação, defeitos e resolução dos bloqueadores.
- [ ] ./mvnw clean verify passa; nenhum teste usa banco de produção ou envia e-mails reais.

### QA-02 — Validar segurança, experiência e desempenho da vitrine

[Issue #24](https://github.com/DelsonAaFilho/A3_Web/issues/24)

- Marco: M6
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RNF01–10, RNF12–14
- Dependências: UI-01, UI-03, UI-04, PUBLIC-01

Executar verificação dirigida aos requisitos não funcionais e corrigir problemas antes da entrega.

Critérios de aceite:

- [ ] Verificar autorização no servidor, IDOR, uploads, validação de entradas e sessão em HTTPS.
- [ ] Avaliar teclado, contraste, texto alternativo e responsividade conforme WCAG 2.1 AA requerida.
- [ ] Verificar duas versões mais recentes de Chrome, Edge, Firefox e Safari na data da homologação.
- [ ] Medir carregamento da página principal em até 3 s com cenário de banda larga e volume de dados documentados; otimizar imagens/lazy loading e consultas.
- [ ] Conferir aviso/ciência de publicação e ausência de senhas/chaves em respostas e logs.

### OPS-01 — Preparar implantação HTTPS, Actuator e recuperação

[Issue #25](https://github.com/DelsonAaFilho/A3_Web/issues/25)

- Marco: M6
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: RNF07, RNF11; Actuator solicitado
- Dependências: TEC-03, MAIL-01, QA-01, QA-02

Definir ambiente de entrega, configuração segura, observabilidade, backup e operação durante exposições. Não contratar infraestrutura sem decisão da equipe.

Critérios de aceite:

- [ ] Disponibilizar HTTPS, variáveis de ambiente, PostgreSQL e storage com permissões adequadas.
- [ ] Proteger endpoints sensíveis do Actuator; expor apenas health necessário e monitorar falhas do banco/storage/e-mail.
- [ ] Documentar execução de migrations, backup e restauração testada, incluindo referências de mídia.
- [ ] Definir rollback da aplicação compatível com migrations, smoke test e responsável por operação nos eventos.

### REL-01 — Consolidar documentação e publicar entrega homologada

[Issue #26](https://github.com/DelsonAaFilho/A3_Web/issues/26)

- Marco: M6
- Tipo: Implementação
- Prioridade: Essencial
- Rastreabilidade: Documentos de docs; CA01–13
- Dependências: OPS-01, DOC-01

Atualizar README e AGENTS conforme implementação real, registrar decisões finais e preparar versão com notas de entrega.

Critérios de aceite:

- [ ] README contém instalação, configuração, execução, testes e links do planejamento.
- [ ] AGENTS mantém convenções do projeto, regras de domínio, segurança e definição de pronto.
- [ ] Notas da versão incluem escopo entregue, limitações conhecidas e evidências de aceite.
- [ ] Marcos são encerrados somente após seus critérios de saída; pendências têm destino explícito.

## Publicação e verificação

Os 6 milestones e as 26 issues foram publicados e verificados por consulta individual à API do GitHub. Foram conferidos títulos, escopo, critérios de aceite, referências, dependências e associação aos marcos. O arquivo `planejamento-github.json` registra os números e URLs remotos. As dependências nas issues usam os números reais do GitHub; os IDs locais permanecem para rastreabilidade.

Antes de republicar ou alterar o backlog, consulte esses registros e os itens remotos para evitar duplicações.
