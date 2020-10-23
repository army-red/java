
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class main {

    static Map<Integer, Charac> toSQL = new HashMap<Integer, Charac>();

    public static void main(String[] args) throws IOException {
        workInCMD();
    }

    public static void workInCMD() throws NumberFormatException, IOException {
        boolean systemFlag = true;

        System.out.println("欢迎进入EarthOL！~");
        while (systemFlag) {
            int choose;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("以下是可用选项");
            System.out.println("1、创建角色 || 2、显示角色列表 || 3、选择角色 || 4、显示信息  || 5、退出系统：");
            try {
                choose = Integer.parseInt(br.readLine());
                switch (choose) {
                    case 1:
                        createChra();
                        break;

                    case 2:
                        showUser();
                        break;

                    case 4:
                        showInfo();
                        break;

                    case 5:
                        systemFlag = false;
                        System.out.println("·退出系统");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                
            }
        }
    }

    public static void createChra() { // 功能： 创建角色
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String reader;

        System.out.println("创建角色：[y]/n ？");
        try {
            reader = br.readLine();
            // System.out.println("=-= :" + reader);
            if (reader.equals("y") || reader.equals("Y")) {

                System.out.println("·角色开始创建");
                Charac ch = null;
                // -----------------------------------------------------
                System.out.println("请输入角色昵称或名称： ");
                String chName = br.readLine();

                System.out.println("请输入角色出生年月日或者跳过： ");
                String date = br.readLine();

                if (date == null || date.equals("")) {
                    ch = new Charac(chName);
                } else {
                    String[] form = date.split("[^0-9]+");
                    // for(int i = 0 ; i < 3;i++){
                    // System.out.println("日期string： " + form[i]);
                    // }
                    Integer[] formInt = { 0, 0, 0 };
                    for (int i = 0; i < 3; i++) {
                        formInt[i] = Integer.parseInt(form[i]);
                        // System.out.println("日期int： " + formInt[i]);
                    }

                    ch = new Charac(chName, new BirthDate(formInt[0], formInt[1], formInt[2]));
                }
                toSQL.put(ch.hashCode(), ch);
                System.out.println("·角色创建成功！ 角色UID为：" + ch.hashCode());

                // Charac get = toSQL.get(ch.hashCode());
                // System.out.println("通过hashcode获取项目名称： " + get.getName());

                // System.out.println("该角色的年龄为： " + ch.birth.getAge() + "岁");

            } else if (reader.equals("n") || reader.equals("N")) {

                System.out.println("·已取消新建角色");
            }
        } catch (Exception e) {
            System.out.println("[error]: " + e);
        }
    }

    public static void showUser() { // 功能： 展示用户
        System.out.println("+--------------+--------------+--------------+");
        System.out.println("|     姓名     |     UID      |     年龄     |");

        System.out.println("+--------------+--------------+--------------+");
        for (Object o : toSQL.keySet()) {
            
            int ages = 0;
            try {
                
                ages = toSQL.get(o).birth.getAge();
            } catch (Exception e) {

            }


            System.out.printf("| %-12s | %-12s | %-12s |\n", toSQL.get(o).getName(), toSQL.get(o).hashCode(), ages);
            System.out.println("+--------------+--------------+--------------+");
        }

    }

    public static void showInfo(){
        System.out.println("=----------------------------------------=");
        System.out.println();
        System.out.println("author: armee_red   version: beta 0.1  ");
        System.out.println("operateMessage: 2020.10.11 做了个基础结构，年龄，名字的数据输入");
        System.out.println();
        System.out.println("=----------------------------------------=");
        System.out.println();
    }
}
