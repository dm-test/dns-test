package com.github.dmtest.support.element.find;

import com.github.dmtest.pages.AnyPage;
import com.github.dmtest.pages.MainPage;
import com.github.dmtest.support.common.CommonSupport;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.List;

public class FindSupport {

    /**
     * @param <T> тип возвращаемого элемента
     * @param context текущий контекст - откуда начинать искать элемент. Может быть страницей - классом-наследником {@code Page} либо комплексным элементом, внутри которого нужно выполнить поиск
     * @param name имя искомого элемента
     * @param wait ожидать появления элемента или нет
     */
    public <T extends WebElement> T find(Object context, String name, boolean wait) {
        AbstractMap.SimpleEntry<Class, Field> classWithField = getClassWithFieldByPath(context, name);
        Object instance = CommonSupport.getInstance(classWithField.getKey());
        classWithField.getValue().get(instance);
    }

    /**
     * @param <T> ожидаемый тип элемента
     * @param name имя или путь элемента
     * @param type тип элемента
     * @param wait ожидать появления элемента или нет
     */
    public <T extends WebElement> T find(String name, Class<T> type, boolean wait) {
        return null;
    }

    /**
     *
     * @param <T> type of the returned element
     * @param name name of the element to be searched
     * @return Returns an element from a page by name or path
     */
    public <T extends WebElement> T find(String name) {
        return find(name, true);
    }

    /**
     * @param <T> type of the returned element
     * @param name name of the element to be searched
     * @param wait to wait for the element to appear or not
     * @return Returns an element from a page by name or path
     */
    public <T extends WebElement> T find(String name, boolean wait) {
        return find(null, name, wait);
    }

    /**
     *
     * @param <T> expected element type
     * @param name element name or path
     * @param type element type
     * @return Returns an element from a page by name or path
     */
    public <T extends WebElement> T find(String name, Class<T> type) {
        return find(name, type, true);
    }

    /**
     *
     * @param <T> expected type of the returned element
     * @param name element name or path to it
     * @param clazz list of valid types. If the element found does not match the
     * valid type, an exception will be thrown
     * @return Returns an element from a page by name or path
     */
    public <T extends WebElement> T find(String name, List<Class> clazz) {
        return find(name, clazz, true);
    }

    /**
     *
     * @param <T> expected type of the returned element
     * @param name element name or path to it
     * @param clazz list of valid types. If the element found does not match the
     * valid type, an exception will be thrown
     * @param wait to wait for the element to appear or not
     * @return Returns an element from a page by name or path
     */
    public <T extends WebElement> T find(String name, List<Class> clazz, boolean wait) {
        return null;

    }

    /**
     * @param <T> тип возвращаемого элемента
     * @param context текущий контекст - откуда начинать искать элемент. Может
     * быть страницей - классом-наследником {@code Page} либо комплексным
     * элементом, внутри которого нужно выполнить поиск
     * @param name имя списка или путь до него
     */
    public <T extends WebElement, E extends WebElement> List<E> findList(T context, String name) {
        return null;

    }

    /**
     *
     * @param <T> type of the returned element
     * @param name list name or path to it
     * @return Returns a list from a page by name or path
     */
    public <T extends WebElement> List<T> findList(String name) {
        return findList(null, name);
    }

    private static AbstractMap.SimpleEntry<Class, Field> getClassWithFieldByPath(Object context, String path)  {
        Class clazz = context.getClass();
        String[] pathArray = path.split("->");
        int lastElementIndex = pathArray.length - 1;
        for (int i = 0; i < lastElementIndex; i++) {
            String name = pathArray[i];
            clazz = getFieldByName(clazz, name).getType();
        }
        Field field = getFieldByName(clazz, pathArray[lastElementIndex]);
        return new AbstractMap.SimpleEntry<>(clazz, field);
    }

    private static Field getFieldByName(Class clazz, String name) {
        List<Field> fields = FieldUtils.getAllFieldsList(clazz);
        return fields.stream()
                .filter(field -> CommonSupport.getAnnotationNameValue(field).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("The class '%s' does not have '@Name' with value '%s'", clazz.getSimpleName(), name)));
    }

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
//        Field field = getFieldByPath(mainPage, "Хедер поиска->Найти");
    }

}
