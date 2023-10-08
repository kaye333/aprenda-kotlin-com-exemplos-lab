// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
enum class StatusUsuario { ATIVO, INATIVO }
enum class Tipo { MOBILE, WEB, FRONTEND, BACKEND, FULLSTACK }

data class Usuario(val nomeUsuario: String, val emailUsuario: String, var statusUsuario: StatusUsuario) {
    override fun toString(): String = "Nome: $nomeUsuario - E-mail: $emailUsuario - Status: $statusUsuario"
}

data class ConteudoEducacional(val nomeConteudo: String, val duracaoConteudo: Int, val descricaoConteudo: String, val nivelConteudo: Nivel) {
    override fun toString(): String = "Conteúdo Educacional: $nomeConteudo, com $duracaoConteudo minutos e nível $nivelConteudo. Descrição: $descricaoConteudo"
}

data class Formacao(val nomeFormacao: String, var conteudosDaFormacao: List<ConteudoEducacional>, val tipoFormacao: String) {

    val inscritosFormacao = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritosFormacao.addAll(usuarios)
    }

    fun cancelarMatricula(usuario: Usuario) {
        inscritosFormacao.remove(usuario)
    }

    override fun toString(): String {
        val nomesAlunos = inscritosFormacao.joinToString(", ") { it.nomeUsuario }
        val nomesConteudos = conteudosDaFormacao.joinToString(", ") { it.nomeConteudo }
        
        return """
        Formação: $nomeFormacao
        Tipo: $tipoFormacao
        Conteúdos: $nomesConteudos
        Alunos: $nomesAlunos
        """.trimIndent()
    }
}

fun main() {
    // Usuarios Teste

    val usuario1 = Usuario("João", "joao@example.com", StatusUsuario.ATIVO)
    val usuario2 = Usuario("Maria", "maria@example.com", StatusUsuario.ATIVO)
    val usuario3 = Usuario("Carlos", "carlos@example.com", StatusUsuario.INATIVO)
    val usuario4 = Usuario("Ana", "ana@example.com", StatusUsuario.ATIVO)
    val usuario5 = Usuario("Pedro", "pedro@example.com", StatusUsuario.ATIVO)

    // Conteúdos Teste
    val conteudoEducacionalKotlinBasico = ConteudoEducacional("Kotlin Básico", 60, "Introdução ao Kotlin", Nivel.BASICO)
    val conteudoEducacionalKotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 90, "Recursos avançados do Kotlin", Nivel.INTERMEDIARIO)
    val conteudoEducacionalDesenvolvimentoAndroid = ConteudoEducacional("Desenvolvimento Android", 120, "Desenvolvimento de aplicativos Android", Nivel.AVANCADO)
    val conteudoEducacionalPythonIntermediario = ConteudoEducacional("Python Intermediário", 75, "Programação em Python", Nivel.INTERMEDIARIO)
    val conteudoEducacionalAngular = ConteudoEducacional("Angular Developer", 36, "Desenvolvimento com Angular", Nivel.AVANCADO)
    val conteudoEducacionalTypeScript = ConteudoEducacional("TypeScript Fullstack Developer", 44, "Desenvolvimento Fullstack com TypeScript", Nivel.AVANCADO)
    val conteudoEducacionalReact = ConteudoEducacional("React Developer", 34, "Desenvolvimento com React", Nivel.AVANCADO)
    val conteudoEducacionalJava = ConteudoEducacional("Java Developer", 150, "Programação em Java", Nivel.INTERMEDIARIO)
    val conteudoEducacionalKotlinAvancado = ConteudoEducacional("Kotlin Avançado", 120, "Programação avançada em Kotlin", Nivel.AVANCADO)
    val conteudoEducacionalSpring = ConteudoEducacional("Spring Framework Developer", 100, "Desenvolvimento com Spring Framework", Nivel.INTERMEDIARIO)
    val conteudoEducacionalFlutter = ConteudoEducacional("Flutter Developer", 90, "Desenvolvimento com Flutter", Nivel.BASICO)
    val conteudoEducacionalPythonAvancado = ConteudoEducacional("Python Avançado", 80, "Programação avançada em Python", Nivel.AVANCADO)

    // Formações Teste
    val formacaoDesenvolvimentoMobile =
            Formacao("Desenvolvimento Mobile", listOf(conteudoEducacionalKotlinBasico, conteudoEducacionalDesenvolvimentoAndroid, conteudoEducacionalFlutter), Tipo.MOBILE.toString())
    val formacaoDesenvolvimentoWeb =
            Formacao("Desenvolvimento Web", listOf(conteudoEducacionalAngular, conteudoEducacionalTypeScript, conteudoEducacionalReact), Tipo.WEB.toString())
    val formacaoJavaAvancado =
            Formacao("Java Avançado", listOf(conteudoEducacionalJava, conteudoEducacionalKotlinAvancado, conteudoEducacionalSpring), Tipo.BACKEND.toString())
    val formacaoKotlinBasico =
            Formacao("Kotlin Básico", listOf(conteudoEducacionalKotlinBasico), Tipo.MOBILE.toString())
    val formacaoPythonIntermediario =
            Formacao("Python Intermediário", listOf(conteudoEducacionalPythonIntermediario), Tipo.BACKEND.toString())


    // Matriculando usuários nas formações

    formacaoDesenvolvimentoMobile.matricular(usuario1, usuario2, usuario3)
    formacaoDesenvolvimentoWeb.matricular(usuario1, usuario4, usuario5)
    formacaoJavaAvancado.matricular(usuario2, usuario4)
    formacaoKotlinBasico.matricular(usuario5)
    formacaoPythonIntermediario.matricular(usuario3)

    // Função para imprimir informações

    fun imprimirInfo(vararg objetos: Any) {
        objetos.forEachIndexed { index, obj ->
            println(obj)
            if (index < objetos.size - 1) {
                println()
            }
        }
    }

    // Imprimindo informações dos usuários matriculados
    imprimirInfo("Usuários:", usuario1, usuario2, usuario3, usuario4, usuario5)
    
    // Imprimindo informações dos Conteúdos Educacionais
    imprimirInfo("Conteúdos:", conteudoEducacionalKotlinBasico, conteudoEducacionalKotlinIntermediario, conteudoEducacionalDesenvolvimentoAndroid, conteudoEducacionalPythonIntermediario)

    // Imprimindo informações das formações com Conteúdos Educacionais e usuários matriculados
    imprimirInfo("Formações:", formacaoDesenvolvimentoMobile, formacaoDesenvolvimentoWeb, formacaoJavaAvancado, formacaoKotlinBasico, formacaoPythonIntermediario)

}
