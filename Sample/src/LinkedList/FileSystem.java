import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class FileSystem {
    /**
     * author: XuHongjun S08352602
     * 
     * I'm not sure that chinese can succesfully pass the encoding so I have to use
     * English
     * 
     * It's a file system which can open/delete/create file And in class File has a
     * Object obj to store the file that I have provide setter and getter Maybe you
     * can add true files in later version (if it will)
     * 
     * MainTree is a basic list, ROOT is a basic file without father class f_choose
     * used to memoried what file user choosing and can source the origin
     */

    static List<File> MainTree = new java.util.LinkedList<File>();
    static final File ROOT = new File("ROOT", MainTree);
    static File f_choose = ROOT;

    public static void main(String[] args) throws Exception {

        /**
         * It's main control UI, very simple no more explaination
         */
        boolean SystemFlag = true;
        while (SystemFlag) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("+---------------------+");
            System.out.println("|    1 add            |");
            System.out.println("|    2 delete         |");
            System.out.println("|    3 show           |");
            System.out.println("|    4 exit           |");
            System.out.println("|    5 open file      |");
            System.out.println("|    6 search         |");
            System.out.println("|    7 back to main   |");
            System.out.println("+---------------------+");

            System.out.println("enter the number to use the function: ");

            int choose = Integer.parseInt(br.readLine());
            switch (choose) {
                case 1:
                    addFile();
                    break;

                case 2:
                    deleteFile();
                    break;

                case 3:
                    showList();
                    break;

                case 4:
                    System.out.println("=-  thankyou for using  -=");
                    SystemFlag = false;
                    break;

                case 5:
                    chooseFile();
                    break;

                case 6:
                    search();
                    break;

                case 7:
                    f_choose = ROOT;
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * read the file name that user want to create, I'll describe detailed
     * file-create at CLASS File
     * 
     * @throws Exception It's may cast exception when using code without UTF-8, you
     *                   can type "chcp 65001" in cmd to javac or javac -encoding
     *                   utf8 ***.java
     */
    public static void addFile() throws Exception {
        System.out.println("================[add]===================");
        System.out.println("input new file name: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        /**
         * If it's not linkedlist of ROOT file, it will have a file link back to father
         * class at first link node So every node will added after the last node and
         * using the name user provided
         */
        ((LinkedList<File>) f_choose.SubTree).addLast(new File(name));
        System.out.println("file create succesed!");
    }

    /**
     * It can delete file according to the name user provided I use iterator to
     * ergodic chosen file
     * 
     * @throws Exception same above
     */
    public static void deleteFile() throws Exception {
        System.out.println("================[delete]===================");
        System.out.println("input file name : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        boolean flag = false;

        for (Iterator<File> choose = f_choose.SubTree.iterator(); choose.hasNext();) {
            File ff = choose.next();

            if ((ff.getName()).equals(name)) {
                flag = true;
                choose.remove();
            }
        }

        if (flag) {
            System.out.println("file deleted!");
        } else {
            System.out.println("can not find file!");
        }
    }

    /**
     * It can show the details about chosen file except in the ROOT file And I don't
     * know how to show the first father node as "..." such as it'll show [ROOT] in
     * second file class So you can back to last class by typing the first node name
     * or using function no.7 back to main, it can back to ROOT file directly If I
     * renamed the father node, it'll still show "..." after back to upper class
     */
    public static void showList() {
        System.out.println("================[show]===================");
        for (File f : (List<File>) f_choose.SubTree) {
            System.out.print(" [ " + f.getName() + " ] ");
        }
        System.out.println();

    }

    /**
     * A very simple function, search the name in linkedlist and store it in to the
     * f_choose So that every function can using f_choose
     * 
     * @throws Exception try to catch exception when it haven't the file user want
     *                   to select And it will show the details about this file by
     *                   showList()
     */
    public static void chooseFile() throws Exception {
        System.out.println("================[choose]===================");
        System.out.println("write file name you choose: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choose = br.readLine();

        try {
            // int count = 0;
            for (File f : (List<File>) f_choose.SubTree) {
                if (choose.equals(f.getName())) {
                    f_choose = f;
                    System.out.println("you have select the file: " + f_choose.getName());
                    showList();
                    break;
                } else {
                    // System.out.println("file select failed");
                }

            }
        } catch (Exception e) {
            System.out.println("file select failed");
        }

    }

    /**
     * Actually I think this function is useless, you can use showList to see all
     * files in this file and more visualable And it will return the position from 0
     * to length - 1, less humanity
     * 
     * @throws Exception same above
     */
    public static void search() throws Exception {
        System.out.println("================[search]===================");
        System.out.println("input name searching for: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        // basic location is -1 so it'll return -1 when you can't find it,
        int loc = -1, i = 0;

        for (File f : (List<File>) f_choose.SubTree) {

            if (name.equals(f.getName())) {
                loc = i;
                break;
            }
            i++;
        }
        System.out.println("it's loacated at: " + loc);
    }
}

/**
 * It's a very simple class with name/obj/List<> name to define the file obj to
 * store the true file but I haven't assemble it yet. It needs FileStream to
 * read text or image or video list is a link to store the location about son
 * files so it's List<File> ll = new LinkedList<File>
 * 
 * File(String name, List<File> SubTree) is special for ROOT file without add
 * father node because it hasn't File(String name) will add the node you have
 * chose past(f_choose) so you can source the father file after enter the son
 * file
 */
class File {
    String name;
    // Integer no, nums;
    Object obj;

    List<File> SubTree = (List<File>) new LinkedList<File>();

    public File(String name) {
        // super();

        this.name = name;
        SubTree = (List<File>) new LinkedList<File>();
        // SubTree.add(this);
        ((LinkedList<File>) SubTree).addLast(FileSystem.f_choose);
    }

    public File(String name, List<File> SubTree) {
        // super();
        this.name = name;
        SubTree = (List<File>) new LinkedList<File>();
    }

    // getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}