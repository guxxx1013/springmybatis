/**
 * @author quanju.gu
 * @date 2018/5/29
 */

public class PrepayOrderPO {

    String name;

    String age;

    boolean test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "PrepayOrderPO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
