package com.library.dto.request;
import java.util.Collection;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallSlipForm {
	    private Long idReader;
	    private Long idUser;
	    private Collection<Long> idbooks;
}
