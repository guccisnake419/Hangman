import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Hangman.Category;

import java.util.ArrayList;

class MyTest {

	//Test cases for Category Class:


	@Test
	//testCategoryConstructorWithArrayList
	public void CategoryTest1() {
		ArrayList<String> words = new ArrayList<>();
		words.add("apple");
		words.add("banana");
		words.add("orange");

		Category category = new Category("Fruits", words);

		Assertions.assertEquals(3, category.list.size());
		Assertions.assertEquals("orange", category.list.peek());

	}

	@Test
	//test2CategoryConstructorWithArrayList
	public void CategoryTest11() {
		ArrayList<String> words = new ArrayList<>();
		words.add("jon");
		words.add("Alex");
		words.add("Dave");

		Category category = new Category("Classmates", words);

		Assertions.assertEquals(3, category.list.size());
		Assertions.assertEquals("Dave", category.list.peek());
		Assertions.assertEquals("Dave", category.list.pop());
		Assertions.assertEquals("Alex", category.list.pop());
	}

	@Test
	//testCategoryConstructorWithStringArray
	public void CategoryTest2() {
		String[] words = {"apple", "banana", "orange"};
		Category category = new Category("Fruits", words);

		Assertions.assertEquals(3, category.list.size());
		Assertions.assertEquals("orange", category.list.peek());
		Assertions.assertEquals("orange", category.list.pop());
		Assertions.assertEquals("banana", category.list.pop());
	}


	@Test
	//test2CategoryConstructorWithStringArray
	public void CategoryTest22() {
		String[] words = {"Jon", "Alex", "Dave"};
		Category category = new Category("Classmates", words);

		Assertions.assertEquals(3, category.list.size());
		Assertions.assertEquals("Dave", category.list.peek());
		Assertions.assertEquals("Dave", category.list.pop());
		Assertions.assertEquals("Alex", category.list.pop());
	}


	@Test
	//testPopulateCategoryWithArrayList
	public void PopulateCategoryTest1() {
		ArrayList<String> words = new ArrayList<>();
		Category category = new Category("Fruits",words);

		words.add("apple");
		words.add("banana");
		words.add("orange");

		category.populateCategory(words);

		Assertions.assertEquals(3, category.list.size());
	}

	@Test
	//test2PopulateCategoryWithArrayList
	public void PopulateCategoryTest2() {
		ArrayList<String> words = new ArrayList<>();
		Category category = new Category("Servers",words);

		words.add("Server1");
		words.add("Server2");
		words.add("Server3");

		category.populateCategory(words);

		Assertions.assertNotEquals(5, category.list.size());
	}

	@Test
	//testPopulateCategoryWithStringArray
	public void PopulateCategoryTest11() {
		Category category = new Category("Fruits");
		String[] words = {"apple", "banana", "orange"};

		category.populateCategory(words);

		Assertions.assertEquals(3, category.list.size());
	}


	@Test
	//testPopulateCategoryWithStringArray
	public void PopulateCategoryTest22() {
		Category category = new Category("Servers");
		String[] words = {"Server1", "Server2", "Server3"};

		category.populateCategory(words);

		Assertions.assertNotEquals(6, category.list.size());
	}


	@Test
	//testEmptyCategory
	public void EmptyCategorytest1() {
		Category category = new Category("Servers");

		Assertions.assertEquals(0, category.list.size());
		Assertions.assertTrue(category.list.isEmpty());
	}

	@Test
	//testEmptyCategory
	public void EmptyCategorytest2() {
		Category category = new Category("Fruits");

		Assertions.assertEquals(0, category.list.size());
		Assertions.assertTrue(category.list.isEmpty());
	}



}
