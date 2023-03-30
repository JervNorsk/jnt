using Mono.Cecil;
using System.ComponentModel;
using System.Linq;
using System.Transactions;
using Unity.Collections;
using UnityEditor.Animations;
using UnityEngine;

namespace JervNorsk.Tool.GeometryNode.Mesh.Primitive
{
    public class Grid : Geometry
    {
        [Min(0)]
        public float sizeX;

        [Min(0)]
        public float sizeZ;

        [Min(2)]
        public int verticesX;

        [Min(2)]
        public int verticesZ;

        protected override void InitAttributes()
        {
            if (sizeX == 0)
            {
                sizeX = 1;
            }

            if (sizeZ == 0)
            {
                sizeZ = 1;
            }

            if (verticesX == 0)
            {
                verticesX = 3;
            }

            if (verticesZ == 0)
            {
                verticesZ = 3;
            }
        }

        protected override void InitMesh()
        {
            base.InitMesh();

            mesh.name = "Grid";

            UpdateMesh();
        }

        protected override void UpdateMesh()
        {
            var vertices = new Vector3[verticesX * verticesZ];
            
            float xPositionMultiplier = sizeX / (verticesX - 1);
            float zPositionMultiplier = sizeZ / (verticesZ - 1);

            int vertexIndex = 0;
            for(int x = 0; x < verticesX; x++)
            {
                for (int z = 0; z < verticesZ; z++)
                {
                    float xPosition = x * xPositionMultiplier;
                    float yPosition = 0;
                    float zPosition = z * zPositionMultiplier;

                    vertices[vertexIndex] = new Vector3(
                        xPosition - (sizeX / 2),
                        yPosition,
                        zPosition - (sizeZ / 2)
                    );

                    vertexIndex++;
                }
            }

            var facesX = verticesX - 1;
            var facesZ = verticesZ - 1;

            Debug.Log(facesX);
            Debug.Log(facesZ);

            var triangles = new int[facesX * facesZ * 6];

            for (int x = 1; x <= facesX; x++)
            {
                for (int z = 1; z <= facesZ; z++)
                {
                    var faceIndex = (x * z) - 1;
                    var triangleIndexOffset = faceIndex * 6;

                    // FIXME: Correggere l'algoritmo di creazione delle facce

                    triangles[triangleIndexOffset + 0] = (faceIndex + 0) % vertices.Length;
                    triangles[triangleIndexOffset + 1] = (faceIndex + 1) % vertices.Length;
                    triangles[triangleIndexOffset + 2] = (faceIndex + 2) % vertices.Length;
                    triangles[triangleIndexOffset + 3] = (faceIndex + 1) % vertices.Length;
                    triangles[triangleIndexOffset + 4] = (faceIndex + 3) % vertices.Length;
                    triangles[triangleIndexOffset + 5] = (faceIndex + 2) % vertices.Length;
                }
            }


            //for (int faceIndex = 0; faceIndex < faceCount; faceIndex++)
            //{
            //    var triangleOffset = faceIndex * 6;

            //    triangles[triangleOffset + 0] = (faceIndex + 0) % vertices.Length;
            //    triangles[triangleOffset + 1] = (faceIndex + 1) % vertices.Length;
            //    triangles[triangleOffset + 2] = (faceIndex + 2) % vertices.Length; 
            //    triangles[triangleOffset + 3] = (faceIndex + 1) % vertices.Length;
            //    triangles[triangleOffset + 4] = (faceIndex + 3) % vertices.Length;
            //    triangles[triangleOffset + 5] = (faceIndex + 2) % vertices.Length;
            //}

            //var triangles = new int[0];


            for (int j = 0; j < vertices.Length; j++)
            {
                Debug.Log("Vertex["+j+"] = " + vertices[j]);
            }

            for (int j = 0; j < triangles.Length; j+=6)
            {
                Debug.Log("Face[" + j / 6 + "] = (" + triangles[j] + ", " + triangles[j + 1] + ", " + triangles[j + 2] + ") (" + triangles[j + 3] + ", " + triangles[j + 4] + ", " + triangles[j + 5] + ")");
            }

            mesh.Clear();
            mesh.vertices = vertices;
            mesh.triangles = triangles;
            mesh.RecalculateNormals();
        }

        public static GameObject CreateGameObject()
        {
            return new GameObject("Grid", typeof(Grid));
        }
    }
}