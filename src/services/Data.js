import axios from "axios"

const REST_API_URL = "http://localhost:8080/"

class Data {
    signIn(data) {
        return axios.post(REST_API_URL + "api/auth/signin", data)
    }
    signUp(data) {
        return axios.post(REST_API_URL + "api/auth/signup", data)
    }
    getHotels(data){
        return axios.get(REST_API_URL + "api/hotels/"+data)
    }
    getAvgNote(data){
        return axios.get(REST_API_URL + "api/hotelR/"+data)
    }
    getOpinions(data){
        return axios.get(REST_API_URL + "api/rating/"+data)
    }
    addReview(data){
        return axios.post(REST_API_URL + "api/rating/"+data.id+"/"+data.note+"/"+data.comment)
    }
    freeRoom(data){
        return axios.get(REST_API_URL + "api/freeRoom/"+data.id+"/"+data.a+"/"+data.in+"/"+data.out)
    }
    roomInfo(data){
        return axios.get(REST_API_URL + "api/room/"+data)
    }
    reserveRoom(data){
        return axios.post(REST_API_URL + "api/reservation/"+data.login+"/"+data.idH+"/"+data.idR+"/"+data.in+"/"+data.out)
    }
    getMyReservations(data){
        return axios.get(REST_API_URL + "api/reservation/"+data)
    }
    test(){
        return axios.get(REST_API_URL + "api/foo3")
    }
}

export default new Data();