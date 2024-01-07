package br.janioofi.vuttr.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(Long id){
        super("No tools found with this id: " + id);
    }

}
