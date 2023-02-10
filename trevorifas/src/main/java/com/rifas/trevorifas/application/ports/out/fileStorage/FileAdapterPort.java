package com.rifas.trevorifas.application.ports.out.fileStorage;

import com.rifas.trevorifas.application.core.domain.File;
import org.springframework.core.io.Resource;

public interface FileAdapterPort {
 String save(File file);
 Resource getFileByName(String name);
}
