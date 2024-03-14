package movie.api.model;

import java.util.UUID;

public record MovieDTO(UUID id, String name, String description, Integer ranking) {

}
