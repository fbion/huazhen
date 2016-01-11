package com.hzframework.config;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by paul on 15-5-21.
 */
public class ConfigWatchService {
    private Map<String, WatchService> watcherMap;

    public ConfigWatchService(List<String> pathList)throws IOException {
        for (String strPath : pathList) {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(strPath.substring(0, strPath.lastIndexOf("/")));

            path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            if (watcherMap == null)
                watcherMap = new HashMap<String, WatchService>();

            watcherMap.put(strPath,watcher);
        }
    }

    public void handleEvents(EventsCallBack eventsCallBack) throws InterruptedException{
        while(true){
            for (Map.Entry<String, WatchService> entry : watcherMap.entrySet()) {
                WatchKey key = entry.getValue().take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();

                    if (kind == OVERFLOW) {
                        continue;
                    }

                    WatchEvent<Path> e = (WatchEvent<Path>) event;
                    Path fileName = e.context();

                    System.out.printf("which fileName is %s%n"
                            , kind.name(), fileName);
                    eventsCallBack.ChangeEvent(entry.getKey());
                    System.out.printf("Event %s has happened,which fileName is %s%n"
                            , kind.name(), fileName);
                }
                if (!key.reset()) {
                    break;
                }
            }
        }
    }
}
