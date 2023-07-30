package org.example;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Roster> rosterArrayList = new ArrayList<>();
        rosterArrayList.add(new Roster(1, "Антонова Елена Анатольевна", 2010));
        rosterArrayList.add(new Roster(2, "Болотова Ольга Михайловна", 2010));
        rosterArrayList.add(new Roster(3, "Варежкина Ольга Александровна", 2010));
        rosterArrayList.add(new Roster(4, "Николаев Игорь Станиславович", 2011));
        rosterArrayList.add(new Roster(5, "Петросян Светлана Сергеевна", 2010));
        rosterArrayList.add(new Roster(6, "Сысоев Андрей Валерьевич", 2011));
        rosterArrayList.add(new Roster(7, "Ухова Анна Леонидовна", 2011));
        rosterArrayList.add(new Roster(8, "Федоров Никита Владимирович", 2011));
        rosterArrayList.add(new Roster(9, "Чекмарев Олег Алексеевич", 2010));

        System.out.println();
        System.out.println("Список учеников: ");

        for (Object roster : rosterArrayList){
            System.out.println(roster);
        }

        rosterArrayList.revert();
        System.out.println();
        System.out.println("Список учеников отсортированный в обратном порядке: ");

        for (Object roster : rosterArrayList) {
            System.out.println(roster);
        }
    }

    static class Roster {
        int id;
        String name;
        int age;

        public Roster (int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "id ученика: " + id + ", имя: " + name + ", год рождения: " + age;
        }
    }

    public static class ArrayList<Note> implements Iterable {
        ListItem<Note> head;
        ListItem<Note> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<Note>() {
                ListItem<Note> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public Note next() {
                    Note data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        public static class ListItem<Note> {
            Note data;
            ListItem<Note> next;
        }

        public boolean empty() {
            return head == null;
        }

        public void add(Note item) {
            ListItem<Note> newItem = new ListItem<>();
            newItem.data = item;
            if (empty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }
        public void revert() {
            if (!empty() && head.next != null) {
                tail = head;
                ListItem<Note> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<Note> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;

                }
            }
        }
    }
}