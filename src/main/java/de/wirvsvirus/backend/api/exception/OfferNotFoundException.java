package de.wirvsvirus.backend.api.exception;

public class OfferNotFoundException extends RuntimeException{
    public OfferNotFoundException(){
        super();
    }

    public OfferNotFoundException(final String msg, final Throwable cause){
        super(msg,cause);
    }

    public OfferNotFoundException(final String msg){
        super(msg);
    }

    public OfferNotFoundException(final Throwable cause){
        super(cause);
    }
}
