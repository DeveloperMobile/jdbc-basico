package part2;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        //1 - Consulta
        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);
        System.out.println();

        //1.1 - Consulta com filtro
        Aluno alunoParaConsulta = alunoDAO.getById(1);
        System.out.println("Aluno: " + alunoParaConsulta);
        System.out.println();

        //2 - Inserção
        Aluno alunoParaInsercao = new Aluno(
                "Matheus",
                43,
                "SP");

        alunoDAO.create(alunoParaInsercao);
        consulta(alunoDAO, 5);
        System.out.println();

        // 3 - Delete
        alunoDAO.delete(5);
        consulta(alunoDAO, 5);
        System.out.println();

        // 4 - Atualizar
        Aluno alunoParaAtualizar = alunoDAO.getById(3);
        alunoParaAtualizar.setNome("Joaquim");
        alunoParaAtualizar.setIdade(18);
        alunoParaAtualizar.setEstado("RS");
        alunoDAO.update(alunoParaAtualizar);
        consulta(alunoDAO, 3);
        System.out.println();
    }

    public static void consulta(AlunoDAO dao, int id) {
        Aluno alunoParaConsulta = dao.getById(id);
        System.out.println("Aluno: " + alunoParaConsulta);
    }
}
