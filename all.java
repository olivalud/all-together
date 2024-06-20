// main 

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Integer> avaliacoes = new ArrayList<>();

    // Criando um instrutor
    Instrutor instrutor = new Instrutor("João", 40, "joao@email.com", "joao123", "senha123", "Programação",
        "Especialista em Java");

    // Criando um curso
    Curso cursoJava = new Curso("Java Básico", "Curso introdutório de Java", instrutor);

    // Criando alunos
    Aluno aluno1 = new Aluno("Maria", 25, "maria@email.com", "maria123", "senha456", "graduação");
    Aluno aluno2 = new Aluno("José", 30, "jose@email.com", "jose123", "senha789", "pós-graduação");

    // Adicionando alunos ao curso
    cursoJava.adicionarAluno(aluno1);
    cursoJava.adicionarAluno(aluno2);

    // Criando aulas
    Aula aula = new Aula("Introdução ao Java", "Conceitos básicos de Java", "1h30");

    // Assistir a aula
    aula.assistir();

    // Avaliar a aula
    aula.avaliar(4);
    aula.avaliar(5);
    aula.avaliar(2);
    aula.avaliar(3);

    // Adicionando aulas ao curso
    System.out.println("Avaliações:");
    for (Integer nota : aula.getAvaliacoes()) {
      System.out.println("- " + nota);

    }
  }
}

// classe pessoa 

public class Pessoa {

  protected String name;
  protected int age;
  protected String email;

  public Pessoa(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  // SOBRECARGA dos métodos de atualizar as infos
  public void atualizarInfo(String name) {
    this.name = name;
  }

  public void atualizarInfo(int age) {
    this.age = age;
  }

  public void atualizarEmail(String email) {
    this.email = email;
  }
}

// Construtor - Inicializa os atributos
// Atributos - Nome, idade e email. ( Name, age, email )
// Métodos 'atualizarInfo' 'atualizarEmail' - 3 métodos SOBRECARREGADOS para
// atualizar name, age,
// email.

-----------

// classe user 

public class Usuario extends Pessoa {

  protected String username;
  protected String senha;

  public Usuario(String name, int age, String email, String username, String senha) {
    super(name, age, email);
    this.username = username;
    this.senha = senha;
  }

  // Verificar se o login é válido
  public boolean verificarLogin() {
    return true;
  }

  public void fazerLogout() {
    // Logout
  }

  public void atualizarInfo() {
    // Atualizar informações
  }
}

// Atributos - username e senha
// Construtor - inicializa atributos herdados ( name, age, email ) e os novos,
// username e senha
// Métodos - verificarLogin(), fazerLogout(), atualizarInfo
----------

// classe Instrutor 

public class Instrutor extends Usuario {

  @SuppressWarnings("unused")
  private String especialidade;
  @SuppressWarnings("unused")
  private String bio;

  public Instrutor(String name, int age, String email, String username, String senha, String especialidade,
      String bio) {
    super(name, age, email, username, senha);
    this.especialidade = especialidade;
    this.bio = bio;
  }

  public Curso criarCurso(String titulo, String descricao) {
    return new Curso(titulo, descricao, this);
  }

  public void atribuirNota(Aluno aluno, int nota) {
    // Atribuir nota
  }

  // Polimorfismo: sobrescrever o método atualizarInfo da classe Usuario
  @Override
  public void atualizarInfo() {
    // Atualizar informações do instrutor
  }

}

// classe curso 

import java.util.ArrayList;
import java.util.List;

public class Curso {
  @SuppressWarnings("unused")
  private String titulo;
  @SuppressWarnings("unused")
  private String descricao;
  @SuppressWarnings("unused")
  private Instrutor instrutor;
  private List<Aluno> alunos;
  private List<Aula> aulas;

  public Curso(String titulo, String descricao, Instrutor instrutor) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.instrutor = instrutor;
    this.alunos = new ArrayList<>();
    this.aulas = new ArrayList<>();
  }

  public void adicionarAula(Aula aula) {
    aulas.add(aula);
  }

  public void removerAula(Aula aula) {
    aulas.remove(aula);
  }

  public void adicionarAluno(Aluno aluno) {
    alunos.add(aluno);
  }
}

// classe aula 

import java.util.ArrayList;
import java.util.List;

public class Aula {
  private String titulo;
  @SuppressWarnings("unused")
  private String conteudo;
  @SuppressWarnings("unused")
  private String duracao;
  private List<Integer> avaliacoes;

  public Aula(String titulo, String conteudo, String duracao) {
    this.titulo = titulo;
    this.conteudo = conteudo;
    this.duracao = duracao;
    this.avaliacoes = new ArrayList<>();
  }

  public void assistir() {
    System.out.println("Assistindo à aula: " + titulo);
  }

  public void avaliar(int nota) {
    if (nota >= 1 && nota <= 5) {
      avaliacoes.add(nota);
      System.out.println("Avaliação adicionada: " + nota);
    } else {
      System.out.println("Nota inválida. Por favor, forneça uma nota entre 1 e 5.");
    }
  }

  public List<Integer> getAvaliacoes() {
    return avaliacoes;
  }
}


