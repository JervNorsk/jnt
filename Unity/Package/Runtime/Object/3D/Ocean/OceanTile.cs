using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace JervNorsk.Tool.Object3D
{
    public class OceanTile : MonoBehaviour
    {
        [HideInInspector]
        public Mesh mesh;

        [HideInInspector]
        public MeshFilter meshFilter;

        [HideInInspector]
        public MeshRenderer meshRenderer;

        private void InitAttributes()
        {
            if(mesh == null)
            {
                mesh = new Mesh();
                mesh.name = "OceanTitleMesh";
            }
        }

        private void InitComponents()
        {
            meshFilter = gameObject.GetComponent<MeshFilter>();

            if (meshFilter == null)
            {
                meshFilter = gameObject.AddComponent<MeshFilter>();
                
                meshFilter.sharedMesh = mesh;
            }

            meshRenderer = gameObject.GetComponent<MeshRenderer>();

            if (meshRenderer == null)
            {
                meshRenderer = gameObject.AddComponent<MeshRenderer>();
            }
        }

        public static GameObject CreateGameObject(Ocean ocean)
        {
            var gameObject = new GameObject("OceanTile", typeof(OceanTile));

            gameObject.transform.parent = ocean.transform;

            return gameObject;
        }

        public void Start()
        {
            Debug.Log("Start");

            Reset();
        }

        public void Reset()
        {
            Debug.Log("Reset");

            InitAttributes();
            InitComponents();
        }
    }
}