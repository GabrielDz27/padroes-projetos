package br.edu.ifsc.criacional.singleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class FormatadorSingleton {
    private ArrayList<String> logs = new ArrayList<>();
    private static FormatadorSingleton instance;
    public enum Tipo{
        DD_MM_YYYY("dd/MM/yyyy"),DD_MM_YYYY_HH_MM_SS("dd/MM/yyyy HH:mm:ss"),HH_MM("HH:mm"),
        HH_MM_SS("HH:mm:ss");
        private SimpleDateFormat formatador;
        Tipo(String formatacao){
            formatador = new SimpleDateFormat(formatacao);
        }
        public String formata(Date date){
            return formatador.format(date);
        }
    }
    private FormatadorSingleton(){};
    public static FormatadorSingleton getInstance() {
        if(instance==null){
            instance = new FormatadorSingleton();
        }
        return instance;
    }
    public String formatar(Tipo tipo, Date data){
        String res = tipo.formatador.format(data);
        logs.add(String.format("%s - %s - %s",Tipo.DD_MM_YYYY_HH_MM_SS.formata(new Date()),
                tipo,res));
        return res;
    }
    public void listarLogs(){
        System.out.println("Listando Logs: ");
        for(String log: logs){
            System.out.println(log);
        }
        System.out.println(" === FIM ===");
    }



}
