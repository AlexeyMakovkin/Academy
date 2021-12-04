package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character>{

    public char[] ch;

    public StdString1(char[] base) {
        ch = new char[base.length];
        for (int i = 0; i < base.length; i++) {
            ch[i] = base[i];
        }
    }

    public StdString1() {
        this(new char[0]);
    }

    public StdString1(StdString1 stdString1) {
        this(stdString1.ch);
    }

    public int length() {
        return this.ch.length;
    }

    public StdString1 append(StdString1 that) {
        if (that == null) {
            throw new NullPointerException();
        }
        int count = 0;
        char[] res = new char[that.length() + this.length()];
        for (int i = 0; i < this.length(); i++) {
            res[count] = this.ch[i];
            count++;
        }
        for (int i = 0; i < that.length(); i++) {
            res[count] = that.ch[i];
            count++;
        }
        return new StdString1(res);
    }

    public char[] toCharArray() {
        return this.ch;
    }

    public char charAt(int index) {
        if (index >= ch.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.ch[index];
    }

    public int indexOf(char target) {
        for (int i = 0; i < this.length(); i++) {
            if (this.ch[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || getClass() != otherObj.getClass()) {
            return false;
        }
        StdString1 that = (StdString1) otherObj;
        return Arrays.equals(ch, that.ch);
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (char c : this) {
            sum += c;
        }
        return sum;
    }

    @Override
    public String toString() {
        return new String(this.ch);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < ch.length;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return ch[count++];
            }
        };
    }

    @Override
    public void forEach(final Consumer<? super Character> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        for (char index : this) {
            action.accept(index);
        }

    }
}
