package prakt17.work1;



//Какой-то код с какого-то явно хорошего сайта :Ъ
// P.s. Не было подходящей библиотеки для установки полного пути до файла, поэтому пришлось искать другие способы
public class CurrentWorkingDirectory{
    String cwd;
    public static void main(String args[]){

        String _cwd=System.getProperty("user.dir");
        System.out.println("Current working directory : "+_cwd + "\\src\\prakt17\\work1");

    }
    public CurrentWorkingDirectory(){
        cwd=System.getProperty("user.dir") + "\\src\\prakt17\\work1";
    }
    public String getPath(){
        cwd=System.getProperty("user.dir") + "\\src\\prakt17\\work1";
        System.out.println("Current working directory : "+cwd);
        return cwd;
    }
    public String getPathFile(String file_name){
        String PathFile = cwd + "\\" + file_name;
        System.out.println("Current working directory : "+PathFile);
        return PathFile;
    }
}