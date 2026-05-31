package br.edu.ifsc.criacional.singleton;

import br.edu.ifsc.criacional.builder.Aluno;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception{
        FormatadorSingleton fmt = FormatadorSingleton.getInstance();
        System.out.println(fmt.formatar(FormatadorSingleton.Tipo.DD_MM_YYYY, new Date()));
        System.out.println(fmt.formatar(FormatadorSingleton.Tipo.DD_MM_YYYY_HH_MM_SS, new Date()));
        System.out.println(fmt.formatar(FormatadorSingleton.Tipo.HH_MM,new Date()));
        System.out.println(fmt.formatar(FormatadorSingleton.Tipo.HH_MM,new Date()));
        System.out.println(fmt.formatar(FormatadorSingleton.Tipo.HH_MM_SS,new Date()));
        Thread.sleep(3000);
        System.out.println(fmt.formatar(FormatadorSingleton.Tipo.HH_MM_SS,new Date()));

        System.out.println("--- Sem o singleton ---");
        System.out.println(FormatadorSingleton.Tipo.DD_MM_YYYY.formata(new Date()));
        System.out.println(FormatadorSingleton.Tipo.DD_MM_YYYY_HH_MM_SS.formata(new Date()));
        System.out.println(FormatadorSingleton.Tipo.HH_MM.formata(new Date()));
        System.out.println(FormatadorSingleton.Tipo.HH_MM_SS.formata(new Date()));
        System.out.println("--- Sem o singleton ---");
        System.out.println();
        fmt.listarLogs();

        FormatadorSingleton fmt2 = FormatadorSingleton.getInstance();
        System.out.println(fmt2.formatar(FormatadorSingleton.Tipo.DD_MM_YYYY, new Date()));
        System.out.println(fmt2.formatar(FormatadorSingleton.Tipo.DD_MM_YYYY_HH_MM_SS, new Date()));
        fmt2.listarLogs();
        FormatadorSingleton.getInstance().formatar(FormatadorSingleton.Tipo.HH_MM,new Date());

        fmt2.listarLogs();
        fmt.listarLogs();

        System.out.println("\n--- AlunoFacadeSingleton ---");
        AlunoFacadeSingleton alunoFacade = AlunoFacadeSingleton.getInstance();
        alunoFacade.add(Aluno.builder().nome("João").build());
        alunoFacade.add(Aluno.builder().nome("Maria").build());
        
        System.out.println("Alunos cadastrados:");
        alunoFacade.getAll().forEach(a -> System.out.println(a.getNome()));

        AlunoFacadeSingleton alunoFacade2 = AlunoFacadeSingleton.getInstance();
        System.out.println("Mesma instância? " + (alunoFacade == alunoFacade2));
    }
}
