package json;

public class Bean {

    public long id;

    public String name;

    public int age;

    public Gender gender;

    public Inner inner;

    public Bean() {

    }

    public Bean(long id, String name, int age, Gender gender, Inner inner) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", inner=" + inner +
                '}';
    }

    public class Inner {

        public String title;

        public Inner() {

        }

        public Inner(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
