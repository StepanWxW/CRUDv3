package controller;

import model.Writer;
import services.WriterServices;

import java.util.List;

public class WriterController {
    private WriterServices services = new WriterServices();
    public Writer create(Writer writer) {
        return services.create(writer);
    }

    public List<Writer> getAll() {
        return services.getAll();
    }

    public Writer getById(Long id) {
        return services.getById(id);
    }
    public void remove(Long id) {
        services.remove(id);
    }
    public Writer update(Writer writer) {
        return services.update(writer);
    }
}
