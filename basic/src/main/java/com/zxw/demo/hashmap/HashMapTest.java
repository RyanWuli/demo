package com.zxw.demo.hashmap;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;

import java.util.HashMap;

/**
 * @Author: Ryan
 * @Date: 2021/6/28 19:33
 * @Version: 1.0
 * @Description:
 */
public class HashMapTest {

    static class Person {
        String name;
        int no;

        public Person(String name, int no) {
            this.name = name;
            this.no = no;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person p = (Person) obj;
            return this.no == p.no;
        }

//        @Override
//        public int hashCode() {
//            return String.valueOf(this.no).hashCode();
//        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", no=").append(no);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        HashMap<Person, String> hashMap = new HashMap<>();
        Person person = new Person("乔峰", 123456);
        hashMap.put(person, "天龙八部");
        System.out.println(hashMap.get(person));

        Person person2 = new Person("萧峰",123456);
        System.out.println(person == person2);
        System.out.println(person.equals(person2));
        System.out.println(hashMap.get(person2));

        hashMap.put(person2, "八部天龙");

        System.out.println("--------------person:" + hashMap.get(person2));
        System.out.println("--------------person2:" + hashMap.get(person));

        System.out.println(person.hashCode() == person2.hashCode());


        System.out.println("--------------------------------------");

        // hash test 2
        Person person3 = new Person("xf", 123456789);
        System.out.println(person.hashCode() == person3.hashCode());
        hashMap.put(person3, "tlbb");

        System.out.println("------------person3:" + hashMap.get(person3));
        System.out.println("------------person:" + hashMap.get(person));
    }
}
