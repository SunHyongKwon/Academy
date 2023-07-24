def find_lat_lng(*addresses):
    import json
    import time
    import urllib.request
    import numpy as np    

    lat = []
    lng = []
    wrong = []
    index = 0
    index_list = []
    for address in addresses:
        try:
            encText =urllib.parse.quote(address)
            url = 'https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query='+ encText
            request = urllib.request.Request(url)
            request.add_header("X-NCP-APIGW-API-KEY-ID",'2hossypbwr')
            request.add_header("X-NCP-APIGW-API-KEY",'7claUZjZEE9LdX6NcmFcROjdNXAqQUqafb1wBrE4')
            response = urllib.request.urlopen(request)
            rescode = response.getcode()
            if(rescode==200):
                response_body = response.read()
                entext = response_body.decode('utf-8')
            else:
                print("Error Code:" + rescode)
            
            data = json.loads(entext)
            lat.append(data['addresses'][0]['y'])
            lng.append(data['addresses'][0]['x'])
            index += 1
        except Exception as e:
            print(e)
            print(address)
            wrong.append(address)
            index_list.append(index)
            lat.append(np.nan)
            lng.append(np.nan)
            index += 1

    return lat,lng
