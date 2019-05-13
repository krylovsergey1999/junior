package tree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenIteratorHasNext() {
        Tree<Integer> tree = new Tree<>(1);
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void whenIteratorNext() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.next(), is(1));
    }

    @Test
    public void whenAddEqualsElement() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 2);
        assertThat(tree.getNodesCount(), is(2));
        tree.add(2, 3);
        tree.add(2, 3);
        assertThat(tree.getNodesCount(), is(3));
    }
}

