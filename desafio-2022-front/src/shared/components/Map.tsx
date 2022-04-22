import React, { useState } from "react";
import { GoogleMap, LoadScript, Marker } from "@react-google-maps/api";

const center = {
    lat: -23.525979688348997,
    lng: -46.927537592193715,
};

interface IMapProps{ 
    width: string,
    height: string,
    onSetLocation: (latLng: google.maps.LatLng) => void
}

export const Maps: React.FC<IMapProps> = ({ onSetLocation, width, height }) => {
    const [marker, setMarker] = useState(null);

    const setLocation = (e:any) => {
        console.log(e)
        onSetLocation?.(e.latLng)
        setMarker(e.latLng)
    };

    return (
        <LoadScript googleMapsApiKey="AIzaSyA219vj0_RTEPleW2sJjX9t1BaKc32IZ-U">
            <GoogleMap
                onClick={setLocation}
                mapContainerStyle={{ width: width, height: height }}
                center={center}
                zoom={15}>
                {marker && <Marker position={marker} draggable />}
            </GoogleMap>
        </LoadScript>
    );
};
