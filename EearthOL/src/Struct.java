import java.util.Calendar;

class Charac {
    String name;
    BirthDate birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(BirthDate birth) {
        this.birth = birth;
    }

    public Charac(String name, BirthDate birth) {
        // super();
        this.name = name;
        this.birth = birth;
    }

    public Charac(String name) {
        // super();
        this.name = name;
    }

}

class Date {
    int year, month, day, hour, sec;

    public Date(int year, int month, int day, int hour, int sec) {
        // super();
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.sec = sec;
    }

    public Date(int year, int month, int day) {
        // super();
        this.year = year;
        this.month = month;
        this.day = day;
    }

}

class BirthDate extends Date {
    public BirthDate(int year, int month, int day) {
        super(year, month, day);
    }

    public int getAge() { // 回传年龄
        try {
            if (!"".equals(this.year) || !"".equals(this.month) || !"".equals(this.day)) {
                Calendar cal = Calendar.getInstance();

                int yearNow = cal.get(Calendar.YEAR); // 当前年份
                int monthNow = cal.get(Calendar.MONTH); // 当前月份
                int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); // 当前日期
                // cal.setTime(birthDay);
                int yearBirth = this.year;
                int monthBirth = this.month;
                int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
                int age = yearNow - yearBirth; // 计算整岁数
                if (monthNow <= monthBirth) {
                    if (monthNow == monthBirth) {
                        if (dayOfMonthNow < dayOfMonthBirth)
                            age--;// 当前日期在生日之前，年龄减一
                    } else {
                        age--;// 当前月份在生日之前，年龄减一
                    }
                }
                //System.out.println(age);
                return age;
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }
    }
}
