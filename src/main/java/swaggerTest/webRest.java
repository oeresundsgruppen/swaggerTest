package swaggerTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@RestController
public class webRest
{

	@ApiOperation(value="test method")
	@RequestMapping(value = "/webAPI", method = RequestMethod.GET)
	public  ModelAndView webAPI()
	{
		
		ModelAndView model = new ModelAndView();
        model.setViewName("OK");
        
        return model;
	}
	
}