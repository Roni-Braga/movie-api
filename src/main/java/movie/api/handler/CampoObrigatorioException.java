package movie.api.handler;

public class CampoObrigatorioException extends BusinessException {

    public CampoObrigatorioException(String campo) {
        super("O Campo %s é obrigatório",campo);
        
    }

}
