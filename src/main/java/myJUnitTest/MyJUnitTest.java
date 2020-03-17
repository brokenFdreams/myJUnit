package myJUnitTest;

import annotations.After;
import annotations.Before;
import annotations.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyJUnitTest {
	public static void start(String path) {
		List<Class<?>> listOfClasses = getListOfClasses(path);
		listOfClasses.forEach(MyJUnitTest::startMethods);
	}

	private static void startMethods(Class<?> clazz) {
		try {
			Object obj = clazz.getConstructor().newInstance();
			getMethods(clazz, Test.class)
					.forEach(method -> tester(method, getMethods(clazz, Before.class), getMethods(clazz, After.class), obj));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void tester(Method test, List<Method> beforeList, List<Method> afterList, Object obj) {
		System.out.println("Test method: " + test.getName());
		try {
			beforeList.forEach(before -> {
				try {
					before.invoke(obj);
				}catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			});
			test.invoke(obj);
			afterList.forEach(after -> {
				try {
					after.invoke(obj);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			});
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private static List<Method> getMethods(Class<?> clazz, Class annotation) {
		return Stream.of(clazz.getMethods())
				.filter(method -> method.getAnnotation(annotation) != null)
				.collect(Collectors.toList());
	}

	private static List<Class<?>> getListOfClasses(String path) {
		return new ArrayList<>(new Reflections(path, new SubTypesScanner(false)).getSubTypesOf(Object.class));
	}

	private static Class<?> findClass(String name) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}
