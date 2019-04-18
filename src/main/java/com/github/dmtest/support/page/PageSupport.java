package com.github.dmtest.support.page;

import com.github.dmtest.pages.AnyPage;
import com.google.common.reflect.ClassPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PageSupport {
    private static final Logger LOG = LoggerFactory.getLogger(PageSupport.class);
    private static final ThreadLocal<Set<Class<?>>> PAGES_REPOSITORY = ThreadLocal.withInitial(HashSet::new);

    private PageSupport() {
    }

    @SuppressWarnings("unchecked")
    private static <T extends AnyPage> T getPageByName(String name) {
        Class<? extends AnyPage> clazz = getPageClassByName(name);
        try {
            Constructor<? extends AnyPage> constructor = clazz.getConstructor();
            constructor.setAccessible(true);
            return (T) (constructor.newInstance());
        } catch (ReflectiveOperationException e) {
            LOG.error("Failed to initialize page '{}'", name);
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends AnyPage> getPageClassByName(String name) {
        return (Class<? extends AnyPage>) getAllClasses().stream()
                .filter(AnyPage.class::isAssignableFrom)
                .filter(clazz -> getAnnotationNameValue(clazz).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No classes with '@Name value()' is '%s'", name)));
    }

    private static String getAnnotationNameValue(Class<?> clazz) {
        return Optional.ofNullable(clazz.getAnnotation(Name.class))
                .map(Name::value)
                .orElse("");
    }

    @SuppressWarnings("UnstableApiUsage")
    private static Set<Class<?>> getAllClasses() {
        Set<Class<?>> allClasses = new HashSet<>();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClassesRecursive("com.github.dmtest.pages")) {
                allClasses.add(info.load());
            }
        } catch (IOException ex) {
            LOG.warn("Failed to read class path resources", ex);
            throw new IOError(ex);
        }
        return allClasses;
    }
}
