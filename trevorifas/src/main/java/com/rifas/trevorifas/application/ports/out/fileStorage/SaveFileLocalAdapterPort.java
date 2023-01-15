package com.rifas.trevorifas.application.ports.out.fileStorage;

import com.rifas.trevorifas.application.core.domain.File;

public interface SaveFileLocalAdapterPort {
 String save(File file);
}
