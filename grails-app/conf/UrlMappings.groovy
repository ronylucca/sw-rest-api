class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/planeta/save"(controller: "planetaViews", action: "save")


        "/planeta/delete/$id?"(controller: "planetaViews", action: "delete")

        "/planeta/show/$id?"(controller: "planetaViews", action: "show")

        "/planeta/edit/$id?"(controller: "planetaViews", action: "edit")

        "/planeta/$id?"(controller:"planeta", parseRequest: false, ) {
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
