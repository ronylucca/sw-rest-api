class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/planeta/save"(controller: "planetaViews", action: "save")



        "/planeta/$id?"(controller:"planeta", parseRequest: false, ) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
