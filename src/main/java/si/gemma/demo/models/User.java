package si.gemma.demo.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    public String name;
    public LocalDateTime date;
}
