package project.Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import project.Common.Request;

import java.io.IOException;
/**
 * Interface for all Commands
 */
public interface InterCommand {

    public String getDescription();

    public String getName();

    public Request execute(String args) throws IOException;
}
