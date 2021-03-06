package com.github.dmtest.support.page;

import com.github.dmtest.pages.AnyPage;
import com.github.dmtest.support.common.CommonSupport;
import com.google.common.reflect.ClassPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PageSupport {
    private static final Logger LOG = LoggerFactory.getLogger(PageSupport.class);
    private static ThreadLocal<Set<Class<? extends AnyPage>>> pageClasses = new ThreadLocal<>();

    private PageSupport() {
    }

    public static <T extends AnyPage> T getNewPageByName(String name) {
        Class<? extends AnyPage> clazz = getPageClassByName(name);
        return CommonSupport.getInstance(clazz);
    }

    private static Class<? extends AnyPage> getPageClassByName(String name) {
        return getPageClasses().stream()
                .filter(clazz -> CommonSupport.getAnnotationNameValue(clazz).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("No classes with '@Name value()' is '%s'", name)));
    }

    @SuppressWarnings("unchecked")
    private static Set<Class<? extends AnyPage>> getPageClasses() {
        if (Objects.isNull(pageClasses.get())) {
            Set<Class<? extends AnyPage>> classes = getAllClasses().stream()
                    .filter(AnyPage.class::isAssignableFrom)
                    .map(clazz -> (Class<? extends AnyPage>) clazz)
                    .collect(Collectors.toSet());
            pageClasses.set(classes);
        }
        return pageClasses.get();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static Set<Class<?>> getAllClasses() {
        Set<Class<?>> allClasses = new HashSet<>();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClassesRecursive("com.github.dmtest.pages")) {
                allClasses.add(info.load());
            }
        } catch (IOException e) {
            LOG.error("Failed to read class path resources", e);
            throw new IOError(e);
        }
        return allClasses;
    }
}
